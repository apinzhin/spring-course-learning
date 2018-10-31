package my_spring;

import lombok.SneakyThrows;
import org.reflections.Reflections;

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

        return object;
    }

    @SneakyThrows
    private <T> void configure(T object) {
        objectConfigurators.forEach(e -> e.configure(object));
    }


}
