package org.eijsink.injection.complex;

import org.eijsink.injection.complex.annotation.Autowired;
import org.eijsink.injection.complex.annotation.SpringAnnotation;
import org.eijsink.injection.complex.repository.MenuRepository;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.*;

public class FrameWork {

    private static Map<String, Object> context = new HashMap<>();

    public static Map<String, Object> getContext() {
        return context;
    }

    public static void wireApplication() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Reflections reflections = new Reflections("org.eijsink.injection.complex");

        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(SpringAnnotation.class);

        for( Class clazz: annotated){
            context.put(clazz.getName(), clazz.getDeclaredConstructor().newInstance());
        }

        for( Class clazz: annotated){

            List<Method> setters = getSetter( clazz);

            if(setters.size() == 0){
                continue;
            }
            for( Method method: setters) {

               //   Annotation annotation = clazz.getAnnotation(Autowired.class);
               // Object instance = clazz.getDeclaredConstructor().newInstance();
                if (method.getDeclaredAnnotationsByType(Autowired.class).length > 0) {

                    Object parameter = getParameters(method);
                    method.invoke(context.get(clazz.getName()), parameter);

                }

            }
        }

    }

    private static Object getParameters(Method method) {

        Class<?>[] classes = method.getParameterTypes();
        return context.get (classes[0].getName());

    }

    private static List<Method> getSetter(Class clazz) {

        Method[] methods = clazz.getMethods();
        List<Method> setters = new ArrayList<>();

        for( Method method: methods){
            if( method.getName().startsWith("set")){
                setters.add(method);
            }
        }

        return setters;
    }
}
