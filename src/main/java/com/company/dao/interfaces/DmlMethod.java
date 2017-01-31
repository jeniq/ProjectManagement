package com.company.dao.interfaces;

public interface DmlMethod<E> {
    Integer insert(E e);

    Integer delete(E e);

    Integer update(E e);
}
