package edu.miu.cs.cs489appsd.lab7.exception.user;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException(String message){
        super(message);
    }
}
