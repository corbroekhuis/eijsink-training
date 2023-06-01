package org.eijsink.annotations.testing.exception;

public class AssertionException extends RuntimeException{

    public AssertionException(){
        super();
    }
    public AssertionException( String message){
        super( message);
    }
}
