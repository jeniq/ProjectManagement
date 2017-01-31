package com.company.services.interfaces;

/**
 * This interface sets rules of actions that can be used for entity editing.
 */
public interface AlterEntity<E> {
    Integer add(E e);

    Integer remove(E e);

    Integer edit(E e);
}
