package my_spring;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {
    @Override
    public <T> T wrapProxy(T object) {
        Class<?> type = object.getClass();

        for (Method method : type.getMethods()) {
            if (method.isAnnotationPresent(Benchmark.class)) {


                if (type.getInterfaces().length == 0) {
                    return (T)Enhancer.create(type, (org.springframework.cglib.proxy.InvocationHandler) (o, method1, args) -> {
                        Method classMethod = type.getMethod(method1.getName(), method1.getParameterTypes());
                        return BenchmarkProxyConfigurator.this.invoke(method1, args, classMethod, object);
                    });
                } else {

                    Object proxy = Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                            Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
                            return BenchmarkProxyConfigurator.this.invoke(method, args, classMethod, object);
                        }
                    });
                    return (T) proxy;
                }
            }
        }
        return object;
    }

    private <T> Object invoke(Method method, Object[] args, Method classMethod, T object) throws IllegalAccessException, InvocationTargetException {
        if (classMethod.isAnnotationPresent(Benchmark.class)) {
            System.out.println("----------- Benchmark begin: " + method.getName() + " -----------");
            long begin = System.nanoTime();
            Object result = method.invoke(object, args);
            System.out.println("----------- Benchmark end, method execution took: " + (System.nanoTime() - begin) + " -----------");
            return result;
        }

        return method.invoke(object, args);
    }
}
