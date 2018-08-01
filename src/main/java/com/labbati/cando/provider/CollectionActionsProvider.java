package com.labbati.cando.provider;

import com.labbati.cando.model.Action;

import java.util.List;

@FunctionalInterface
public interface CollectionActionsProvider<T> {

    List<Action> provide(Class<T> t, Boolean includeDeniedActions, Boolean includeInactiveConstraints);
}
