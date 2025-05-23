package com.example.demo.exception;

/**
 * Exception class used to handle errors related to user management operations.
 * This custom exception class provides specific error messages for different user management issues.
 * It extends {@link Exception} and includes several static constant messages that can be used to provide
 * more descriptive error messages related to user creation, authentication, schedule issues, and more.
 */
public class DateException extends Exception {

    public static String InvalidDate= "Fecha Invalida";
    public static String NotOptions = "Faltan campos por llenas";

    public DateException(String message) {
        super(message);
    }
}
