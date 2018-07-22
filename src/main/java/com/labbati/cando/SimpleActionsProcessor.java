package com.labbati.cando;

import java.util.Collection;
import java.util.stream.Collectors;

public final class SimpleActionsProcessor implements ActionsProcessor {

    private final static String PROVIDER_NOT_FOUND = "This actions processor does not provide default actions providers.";

    @Override
    public <T> CollectionAndActions<T> processCollection(Class<T> type, Collection<T> entities, ActionsProvider<T> provider) {
        return new CollectionAndActions<>(
            type,
            entities.stream().map(e -> processEntity(e, provider)).collect(Collectors.toList()),
            provider.getCollectionActions(type, entities)
        );
    }

    @Override
    public <T> CollectionAndActions<T> processCollection(Class<T> type, Collection<T> entities) throws ActionProviderNotFound {
        throw new ActionProviderNotFound(PROVIDER_NOT_FOUND);
    }

    @Override
    public <T> EntityAndActions<T> processEntity(T entity, ActionsProvider<T> provider) {
        return new EntityAndActions<>(entity, provider.getEntityActions(entity));
    }

    @Override
    public <T> EntityAndActions<T> processEntity(T entity) throws ActionProviderNotFound {
        throw new ActionProviderNotFound(PROVIDER_NOT_FOUND);
    }
}
