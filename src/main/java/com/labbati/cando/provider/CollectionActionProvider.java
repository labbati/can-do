package com.labbati.cando.provider;

import com.labbati.cando.model.Action;

@FunctionalInterface
public interface CollectionActionProvider<T> {

    Action provide(Class<T> type, Boolean includeInactiveConstraints);
}
