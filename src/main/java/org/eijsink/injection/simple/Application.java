package org.eijsink.injection.simple;

import org.eijsink.injection.simple.annotation.Value;
import org.eijsink.injection.simple.annotation.jdbc.DataSource;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class Application {

    private static Map<String, String> properties = new HashMap();

    static{
        properties.put("db.url","jdbc://accsrv01:3314/eijsdbacc");
        properties.put("db.user","accusr");
        properties.put("db.password","J3d6CC4k7");
    }

    public static void main(String[] args) throws Exception {

        Class<DataSource> annotated = DataSource.class;
        Field[] fields = annotated.getDeclaredFields();

        DataSource dataSource = annotated.getDeclaredConstructor().newInstance();

        for( Field field: fields){
            Value annotation = field.getAnnotation(Value.class);
            if(annotation != null){
                String key = annotation.key();
                String value = properties.get(key);
                field.set(dataSource,  value);
            }
        }

        Connection connection = dataSource.getConnection();
    }
}
