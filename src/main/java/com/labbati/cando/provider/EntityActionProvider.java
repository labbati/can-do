package com.labbati.cando.provider;

import com.labbati.cando.model.Action;

@FunctionalInterface
public interface EntityActionProvider<T> {

    Action provide(T entity, Boolean includeInactiveConstraints);
}
