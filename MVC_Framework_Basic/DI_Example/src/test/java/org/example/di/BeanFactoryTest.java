package org.example.di;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;
import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.junit.jupiter.api.BeforeEach;
import org.reflections.Reflections;

class BeanFactoryTest {
    private Reflections reflections;
    private BeanFactory beanFactory;

    @BeforeEach
    void setUp() {
        /*리플렉션 초기화-org.example 패키지 아래 클래스&모듈에 리플랙션 사용*/
        reflections = new Reflections("org.example");
        //UserController, UserServices
        Set<Class<?>> preInstantiatedClass = getTypesAnnotatedWith(Controller.class, Service.class); //탑-다운 방식
        beanFactory = new BeanFactory(preInstantiatedClass);
    }

    /*Annotation 클래스 객체가 여러 개 들어올 수 있음 */
    private Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation>... annotations) {
        Set<Class<?>> beans = new HashSet<>();
        for (Class<? extends Annotation> annotation: annotations) {
            beans.addAll(reflections.getTypesAnnotatedWith(annotation));
        }
        return beans;
    }
}