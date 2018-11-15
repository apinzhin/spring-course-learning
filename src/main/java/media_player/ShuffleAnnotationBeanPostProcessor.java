package media_player;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

@Component
public class ShuffleAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {


        Field[] fields = bean.getClass().getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Shuffle.class)) {
                field.setAccessible(true);
                try {
                    Collections.shuffle((List)field.get(bean));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
