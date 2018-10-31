package my_spring;

import java.lang.reflect.InvocationHandler;
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
                Object proxy = Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
                        if (classMethod.isAnnotationPresent(Benchmark.class)) {
                            System.out.println("----------- Benchmark begin: " + method.getName() + " -----------");
                            long begin = System.nanoTime();
                            Object result = method.invoke(object, args);
                            System.out.println("----------- Benchmark end, method execution took: " + (System.nanoTime() - begin) + " -----------");
                            return result;
                        }

                        return method.invoke(object, args);
                    }
                });
                return (T)proxy;
            }
        }
        return object;
    }
}
