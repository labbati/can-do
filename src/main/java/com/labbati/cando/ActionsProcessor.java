package com.labbati.cando;

public interface ActionsProcessor {

    <T> CollectionAndActions<T> processCollection(Class<T> type, CollectionActionProvider<T> provider);

    <T> CollectionAndActions<T> processCollection(Class<T> type) throws ActionProviderNotFound;

    <T> EntityAndActions<T> processEntity(T entity, EntityActionProvider<T> provider);

    <T> EntityAndActions<T> processEntity(T entity) throws ActionProviderNotFound;
}
