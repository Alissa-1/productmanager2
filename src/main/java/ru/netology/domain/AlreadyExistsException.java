package ru.netology.domain;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String msg) {
        super(msg);
        System.out.println(msg);
    }
}
