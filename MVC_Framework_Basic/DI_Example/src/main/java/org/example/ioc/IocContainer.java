package org.example.ioc;

import java.util.HashSet;
import java.util.Set;
import org.example.controller.UserController;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocContainer {

    public static void main(String[] args) {
        Set<Class<?>> preInstantiatedClasses = new HashSet<>();
        preInstantiatedClasses.add(UserController.class);
        preInstantiatedClasses.add(UserService.class);

        ApplicationContext context = new AnnotationConfigApplicationContext(preInstantiatedClasses.toArray(new Class<?>[0]));

        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);
            System.out.println("Bean name: " + beanName + ", Bean class: " + bean.getClass().getName());
        }


    }

}
