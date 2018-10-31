package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

/**
 *
 */
public class InjectRandomIntObjectConfigurator implements ObjectConfigurator {


    @Override
    @SneakyThrows
    public <T> void configure(T object) {

        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                field.setAccessible(true);
                int random = new Random(123).nextInt(annotation.max() - annotation.min()) + annotation.min();
                field.set(object, random);
            }
        }
    }
}
