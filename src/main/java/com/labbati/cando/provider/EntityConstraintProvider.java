package com.labbati.cando.provider;

import com.labbati.cando.Constraint;

import java.util.function.Function;

public interface EntityConstraintProvider<T> extends Function<T, Constraint> {
}
