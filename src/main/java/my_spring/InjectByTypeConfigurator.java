package my_spring;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 *
 */
public class InjectByTypeConfigurator implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public <T> void configure(T object) {
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            InjectByType annotation = field.getAnnotation(InjectByType.class);
            if (annotation != null) {
                field.setAccessible(true);
                field.set(object, ObjectFactory.getInstance().createObject(field.getType()));
            }
        }
    }
}
