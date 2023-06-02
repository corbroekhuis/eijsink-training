package org.eijsink.annotations.testing;

import org.eijsink.annotations.testing.annotation.BeforeEach;
import org.eijsink.annotations.testing.annotation.Test;
import org.eijsink.annotations.testing.test.CalculatorTest;
import org.eijsink.annotations.util.Util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TestFrameWork {

    private static void runAllTests() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException{
        int succes = 0;
        int failed = 0;
        int total = 0;

        Method beforeEach = null;

        Class<CalculatorTest> annotated = CalculatorTest.class;

        List<Method> testMethods = Util.getAnnotatedMethods(annotated, Test.class);
        List<Method> beforeEachMethods = Util.getAnnotatedMethods(annotated, BeforeEach.class);

        if(beforeEachMethods.size() > 0) {
             beforeEach = beforeEachMethods.get(0);
        }

        CalculatorTest calculatorTest = annotated.getDeclaredConstructor().newInstance();

        for( Method method: testMethods){
            Annotation annotation = method.getAnnotation(Test.class);
            Test test = (Test)annotation;
            if( test.skip()){
                System.out.println("Test " + method.getName() + " skipped ");
                continue;
            }
            try {
                if( beforeEach != null){
                    beforeEach.invoke(calculatorTest);
                }

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
            e.printStackTrace();
            // Don't leave this empty
        }

    }
}
