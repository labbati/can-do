package com.labbati.cando.processor;

import com.labbati.cando.CollectionAndActions;
import com.labbati.cando.EntityAndActions;
import com.labbati.cando.provider.CollectionActionsProvider;
import com.labbati.cando.provider.EntityActionsProvider;

import java.util.Collection;

public interface ActionsProcessor {

    <T> CollectionAndActions<T> processCollection(
        Class<T> type,
        Collection<T> entities,
        CollectionActionsProvider<T> collectionActionsProvider,
        EntityActionsProvider<T>... entityActionsProviders
    );

    <T> EntityAndActions<T> processEntity(T entity, EntityActionsProvider<T>... entityActionsProviders);
}
