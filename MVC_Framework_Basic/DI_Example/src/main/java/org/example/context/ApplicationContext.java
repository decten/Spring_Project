package org.example.context;


import java.util.Set;
import org.example.di.BeanFactory;

public class ApplicationContext  {
    private final BeanFactory beanFactory;

    public ApplicationContext(Set<Class<?>> preInstantiatedClasses) {
        this.beanFactory = new BeanFactory(preInstantiatedClasses);
    }

    public <T> T getBean(Class<?> requiredType) {
        return beanFactory.getBean(requiredType);
    }

    public void registerBean(Class<?> beanClass, Object beanInstance) {
        beanFactory.registerBean(beanClass, beanInstance);
    }
}
