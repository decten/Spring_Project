package org.example.di;

import java.lang.reflect.Constructor;
import java.util.Set;
import org.example.annotation.Inject;
import org.reflections.ReflectionUtils;

public class BeanFactoryUtils {
    public static Constructor<?> getInjectedConstructor(Class<?> clazz){
        //inject가 붙은 모든 클래스의 생성자를 가져온다
        Set<Constructor> injectedConstrctors = ReflectionUtils.getAllConstructors(clazz,
            ReflectionUtils.withAnnotation(Inject.class));
        if(injectedConstrctors.isEmpty()) return null;
        //첫 번째 인자 리턴
        return injectedConstrctors.iterator().next();
    }
}
