package com.labbati.cando;

import java.util.Collection;

public interface ActionsProcessor {

    <T> CollectionAndActions<T> processCollection(Class<T> type, Collection<T> entities, ActionsProvider<T> provider);

    <T> CollectionAndActions<T> processCollection(Class<T> type, Collection<T> entities) throws ActionProviderNotFound;

    <T> EntityAndActions<T> processEntity(T entity, ActionsProvider<T> provider);

    <T> EntityAndActions<T> processEntity(T entity) throws ActionProviderNotFound;
}
