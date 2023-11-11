package ru.netology;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String player) {
        super("Игрок с именем " + player + " не зарегистрирован");
    }
}
