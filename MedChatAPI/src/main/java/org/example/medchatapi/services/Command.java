package org.example.medchatapi.services;

public interface Command<T> {
    T execute();
}
