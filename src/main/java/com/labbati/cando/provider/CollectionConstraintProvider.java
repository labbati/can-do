package com.labbati.cando.provider;

import com.labbati.cando.Constraint;

import java.util.function.Function;

public interface CollectionConstraintProvider<T> extends Function<Class<T>, Constraint> {
}
