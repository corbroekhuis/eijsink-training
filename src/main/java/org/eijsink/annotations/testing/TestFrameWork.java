package org.eijsink.annotations.testing;

import org.eijsink.annotations.testing.annotation.Test;
import org.eijsink.annotations.testing.exception.AssertionException;
import org.eijsink.annotations.testing.test.CalculatorTest;
import org.eijsink.annotations.util.Util;
import org.eijsink.injection.simple.annotation.jdbc.DataSource;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TestFrameWork {

    private static void runAllTests() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException{
        int succes = 0;
        int failed = 0;
        int total = 0;

        Class<CalculatorTest> annotated = CalculatorTest.class;

        List<Method> testMethods = Util.getAnnotatedMethods(annotated, Test.class);

        CalculatorTest calculatorTest = annotated.getDeclaredConstructor().newInstance();

        for( Method method: testMethods){
            Annotation annotation = method.getAnnotation(Test.class);
            Test test = (Test)annotation;
            if( test.skip()){
                System.out.println("Test " + method.getName() + " skipped ");
                continue;
            }
            try {
                method.invoke(calculatorTest);
                succes ++;
                System.out.println("Test " + method.getName() + " OK! ");
            }catch(InvocationTargetException e){
                failed ++;
                System.out.println("Test " + method.getName() + " failed: " + e.getCause().getMessage());
            }
            total++;
        }

        System.out.println("Total tests: " + total);
        System.out.println("Succesful : " + succes);
        System.out.println("Failed: " + failed);
    }

    public static void runTests() {
        try {
            runAllTests();
        }catch( Exception e){
            // Don't leave this empty
        }

    }
}
