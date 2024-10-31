package org.example.exceptions;

public class NotAuthenticateException extends Exception {

    public NotAuthenticateException(){
        super("Username or password is not correct");
    }


}
