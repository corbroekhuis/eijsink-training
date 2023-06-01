package org.eijsink.annotations.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static <T extends Annotation> List<String> getGetters(Class<?> subject, Class<T> annotation) {

        List<String> getters = new ArrayList<>();

        for(Field field :subject.getDeclaredFields()){

            T[] ts = field.getAnnotationsByType(annotation);

            if( ts.length == 0){
                continue;
            }

            String methodName = getValidMethodname(field, "get");

            getters.add(methodName);
        }

        return getters;

    }

    public static <T extends Annotation> List<Method> getAnnotatedMethods(Class<?> subject, Class<T> annotation) {

        List<Method> methods = new ArrayList<>();

        for(Method method :subject.getDeclaredMethods()){

            T[] ts = method.getAnnotationsByType(annotation);

            if( ts.length == 0){
                continue;
            }

            methods.add(method);
        }

        return methods;

    }

    public static String getValidMethodname( Field field, String prefix){

        return getValidMethodname(field.getName(), prefix);

    }

    public static String getValidMethodname( String fieldName, String prefix){

        StringBuilder sb = new StringBuilder();

        if(fieldName.length() == 1){
            return prefix + fieldName.toUpperCase();
        }

        if(Character.isUpperCase(fieldName.charAt(1) )){
            sb.append( fieldName.substring(0, 1));
        }else{
            sb.append( fieldName.substring(0, 1).toUpperCase());
        }

        sb.append( fieldName.substring(1));

        sb.insert(0, prefix) ;

        return sb.toString();

    }
}

