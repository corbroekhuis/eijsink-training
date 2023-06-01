package org.eijsink.annotations.testing.assertion;

import org.eijsink.annotations.testing.exception.AssertionException;

public class Assertions {

    public static boolean assertEquals(boolean expected, boolean actual) {
        if(expected != actual){
            throw new AssertionException(String.format("Not equal, expected %s but was %s", expected, actual));
        }
        return true;
    }
    public static boolean assertTrue(boolean actual) {
        if( !actual){
            throw new AssertionException("Not true");
        }
        return true;
    }
    public static boolean assertFalse(boolean actual) {
        if( actual ){
            throw new AssertionException("Not false");
        }
        return false;
    }

    public static boolean assertEquals(String expected, String actual) {
        if( !expected.equals(actual)){
            throw new AssertionException(String.format("Not equal, expected %s but was %s", expected, actual));
        }
        return true;
    }

    public static boolean assertEquals(int expected, int actual) {
        if( expected != actual){
            throw new AssertionException(String.format("Not equal, expected %s but was %s", expected, actual));
        }
        return true;
    }

}
