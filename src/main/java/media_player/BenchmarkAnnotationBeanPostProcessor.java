package media_player;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();

        for (Method beanMethod : beanClass.getMethods()) {
            if (beanMethod.isAnnotationPresent(Benchmark.class)) {
                return Proxy.newProxyInstance(this.getClass().getClassLoader(), beanClass.getInterfaces(),
                        new InvocationHandler() {
                            @Override
                            public Object invoke(Object proxy1, Method method, Object[] args) throws Throwable {
                                Method originalBeanMethod = beanClass.getMethod(method.getName(), method.getParameterTypes());

                                if (originalBeanMethod.isAnnotationPresent(Benchmark.class)) {
                                    System.out.println("............. Benchmark started ..............");
                                    long start = System.nanoTime();
                                    Object result = method.invoke(bean, args);
                                    System.out.println("............. Benchmark finished, method took " + (System.nanoTime() - start) + " ..............");
                                    return result;
                                } else {
                                    return method.invoke(bean, args);
                                }
                            }
                        });
            }
        };

        return bean;


    }
}
