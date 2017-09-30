package com.fontoura.jabel.restaurantemobile.infra.dao;

import java.util.List;

/**
 * Created by Jabel on 09/30/2017.
 */

public interface Dao<T> {
    void insert(T t);
    List<T> buscarTodos();
    T buscarPorId(long id);
    void deletar(long id);
}
