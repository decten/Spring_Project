package org.example.di;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.example.controller.UserController;

public class BeanFactory {

    private final Set<Class<?>> preInstantiatedClass;
    // Class 타입을 키로 가지고, Class로 생성된 Object를 값으로 갖는 객체
    private Map<Class<?>, Object> beans = new HashMap<>();

    public BeanFactory(Set<Class<?>> preInstantiatedClass) {
        this.preInstantiatedClass = preInstantiatedClass;
    }

    public <T> T getBean(Class<?> requiredType) {
        //requiredType(Class)를 키로 가진 Object 반환
        return (T)beans.get(requiredType);
    }
}
