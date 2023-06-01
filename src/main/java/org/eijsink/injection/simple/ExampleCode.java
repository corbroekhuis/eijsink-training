package org.eijsink.injection.simple;

import org.eijsink.injection.simple.annotation.jdbc.DataSource;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExampleCode {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<DataSource> dataSource = DataSource.class;
        Field[] fields = dataSource.getDeclaredFields();
        Method[] methods = dataSource.getDeclaredMethods();
        Annotation[] annotations = dataSource.getAnnotations();

        DataSource instance = dataSource.getDeclaredConstructor().newInstance();
        Method method = dataSource.getMethod("someMethodWithOneStringParameter", String.class);
        Integer result = (Integer)method.invoke( instance, "Hello");

    }
}
