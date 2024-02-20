package ru.fafurin.lesson8.exception;

public class InvalidInputDataException extends RuntimeException {
    public InvalidInputDataException() {
        super("Invalid input data");
   }
}
