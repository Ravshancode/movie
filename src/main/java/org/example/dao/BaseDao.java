package org.example.dao;

import java.util.List;

public interface BaseDao<T,R> {
    T findById(int id);
    List<T> findAll();

    T save(R r);
}
