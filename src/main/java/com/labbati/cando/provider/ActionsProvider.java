package com.labbati.cando.provider;

import com.labbati.cando.model.CollectionAndActions;
import com.labbati.cando.model.EntityAndActions;

import java.util.Collection;

public interface ActionsProvider {

    <T> CollectionAndActions<T> provideForCollection(
        Class<T> type,
        Collection<T> entities,
        CollectionActionsProvider<T> collectionActionsProvider,
        EntityActionsProvider<T>... entityActionsProviders
    );

    <T> EntityAndActions<T> provideForEntity(T entity, EntityActionsProvider<T>... entityActionsProviders);
}
