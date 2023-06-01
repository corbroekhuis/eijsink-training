package org.eijsink.injection.complex;

import org.eijsink.injection.complex.annotation.Autowired;
import org.eijsink.injection.complex.annotation.SpringAnnotation;
import org.eijsink.injection.complex.repository.MenuRepository;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

            Method method = getSetter( clazz);
            if(method == null){
                continue;
            }
         //   Annotation annotation = clazz.getAnnotation(Autowired.class);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            if(method.getDeclaredAnnotationsByType(Autowired.class).length > 0){
                Object parameter = getParameters( method);
                method.invoke( instance, parameter);

            }
            context.put(clazz.getName(), clazz.getDeclaredConstructor().newInstance());
        }

    }

    private static Object getParameters(Method method) {

        Class<?>[] classes = method.getParameterTypes(); // Only one setter
        return context.get (classes[0].getName());

    }

    private static Method getSetter(Class clazz) {

        Method[] methods = clazz.getMethods();

        for( Method method: methods){
            if( method.getName().startsWith("set")){
                return method;
            }
        }

        return null;
    }
}
