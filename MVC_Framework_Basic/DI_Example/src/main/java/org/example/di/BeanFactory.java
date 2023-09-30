package org.example.di;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.example.annotation.Inject;
import org.example.controller.UserController;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;

public class BeanFactory {

    private final Set<Class<?>> preInstantiatedClass;
    // Class 타입을 키로 가지고, Class로 생성된 Object를 값으로 갖는 객체
    private Map<Class<?>, Object> beans = new HashMap<>();

    public BeanFactory(Set<Class<?>> preInstantiatedClass) {
        this.preInstantiatedClass = preInstantiatedClass;
        initialize();
    }
    private void initialize(){
        for(Class<?> clazz: preInstantiatedClass){
            Object instance = createInstance(clazz);
            beans.put(clazz, instance);
        }
    }

    private Object createInstance(Class<?> clazz) {
        //인스턴스 생성하기 위해 생성자와 파라미터 조회
        Constructor<?> constructor = findConstructor(clazz);
        List<Object> parameters = new ArrayList<>();
        for (Class<?> typeClass:constructor.getParameterTypes()){
            parameters.add(getParameterByClass(typeClass));
        }
        try {
            return constructor.newInstance(parameters.toArray());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    private Constructor<?> findConstructor(Class<?> clazz){
        //inject가 붙은 모든 클래스의 생성자를 가져온다
        Constructor<?> constructor = BeanFactoryUtils.getInjectedConstructor(clazz);

        if(Objects.nonNull(constructor)){
            return constructor;
        }
        return clazz.getConstructors()[0];
    }
    private Object getParameterByClass(Class<?> typeClass) {
        Object instances = getBean(typeClass);

        if(Objects.nonNull(instances)){
            return instances;
        }
        //UserController는 UserService가 필요하기 때문에 재귀함수로 재생성
        return createInstance(typeClass);
    }
    public <T> T getBean(Class<?> requiredType) {
        //requiredType(Class)를 키로 가진 Object 반환
        return (T)beans.get(requiredType);
    }

    public void registerBean(Class<?> beanClass, Object beanInstance) {
        beans.put(beanClass, beanInstance);
    }
}
