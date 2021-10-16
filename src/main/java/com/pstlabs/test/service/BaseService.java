package com.pstlabs.test.service;

import com.pstlabs.test.entity.User;

import java.util.List;

public interface BaseService<T, S> {
    T create(T t);

    T getById(S s);

    List<T> getAll();

    T update(T t);

    void delete(T t);
}
