package com.labbati.cando.provider;

import com.labbati.cando.model.Constraint;

@FunctionalInterface
public interface CollectionConstraintProvider<T> {

    Constraint provide(Class<T> type);
}
