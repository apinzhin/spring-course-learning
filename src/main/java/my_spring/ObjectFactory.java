package my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class ObjectFactory {

    private final static ObjectFactory instance = new ObjectFactory();

    private List<ObjectConfigurator> objectConfigurators = new ArrayList<>();

    private Config config = new Config();

    public static ObjectFactory getInstance() {
        return instance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Reflections scanner = new Reflections(config.packagesToScan());
        Set<Class<? extends ObjectConfigurator>> objectConfiguratorTypes = scanner.getSubTypesOf(ObjectConfigurator.class);

        for (Class<? extends ObjectConfigurator> objectConfiguratorType : objectConfiguratorTypes) {
            objectConfigurators.add(objectConfiguratorType.newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }
        T object = type.newInstance();

        configure(object);

        postConstruct(object);

        return object;
    }

    @SneakyThrows
    private <T> void configure(T object) {
        objectConfigurators.forEach(e -> e.configure(object));
    }

    @SneakyThrows
    private <T> void postConstruct(T object) {
        for (Method method : object.getClass().getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(object);
            }
        }
    }



}
