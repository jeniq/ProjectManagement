package com.company.services.interfaces;

/**
 * This interface sets rules of actions that can be used for entity editing.
 */
public interface AlterEntity<E> {
    boolean add(E e);
    Integer remove(E e);
    boolean edit(E e);
}
