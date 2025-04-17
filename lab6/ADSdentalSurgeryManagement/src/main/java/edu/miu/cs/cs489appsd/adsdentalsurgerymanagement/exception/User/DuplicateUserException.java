package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.exception.User;

public class DuplicateUserException extends RuntimeException{
    public DuplicateUserException(String message){
        super(message);
    }
}
