package ru.fafurin.lesson8.exception;

public class NotEnoughProductsCountException extends RuntimeException {
    public NotEnoughProductsCountException(int id) {
        super("Not enough count of product by id " + id);
    }
}
