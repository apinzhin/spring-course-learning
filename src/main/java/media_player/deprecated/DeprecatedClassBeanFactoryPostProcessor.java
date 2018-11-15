package media_player.deprecated;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class DeprecatedClassBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        try {
        
            String[] names = beanFactory.getBeanDefinitionNames();
            for (String name : names) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
                String beanClassName = beanDefinition.getBeanClassName();

                if (beanClassName == null) {
                    continue;
                }
                Class<?> beanClass = Class.forName(beanClassName);
                DeprecatedClass deprecatedClass = beanClass.getAnnotation(DeprecatedClass.class);
                if (deprecatedClass != null) {
                    beanDefinition.setBeanClassName(deprecatedClass.newClass().getName());
                }
            }
    

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
