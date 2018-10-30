package my_spring;

import lombok.SneakyThrows;

/**
 *
 */
public class ObjectFactory {

    private final static ObjectFactory instance = new ObjectFactory();

    private Config config = new Config();

    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return instance;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }
        
        return type.newInstance();
    }


}
