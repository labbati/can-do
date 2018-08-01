package com.labbati.cando.provider;

import com.labbati.cando.model.Constraint;

@FunctionalInterface
public interface EntityConstraintProvider<T> {

    Constraint provide(T entity);
}
