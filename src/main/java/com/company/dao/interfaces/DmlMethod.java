package com.company.dao.interfaces;

public interface DmlMethod<E> {
    int insert(E e);
    int delete(E e);
    int update(E e);
}
