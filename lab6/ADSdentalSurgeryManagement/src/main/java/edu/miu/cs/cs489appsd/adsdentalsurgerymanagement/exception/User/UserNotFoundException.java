package edu.miu.cs.cs489appsd.adsdentalsurgerymanagement.exception.User;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
