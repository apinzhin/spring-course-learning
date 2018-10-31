package my_spring;

/**
 *
 */
public interface ProxyConfigurator {

    <T> T wrapProxy(T object);

}
