package com.labbati.cando.provider;

import com.labbati.cando.model.Action;

import java.util.List;

@FunctionalInterface
public interface EntityActionsProvider<T> {

    List<Action> provide(T entity, Boolean includeDeniedActions, Boolean includeInactiveConstraints);
}
