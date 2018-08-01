package com.labbati.cando.provider;

import com.labbati.cando.model.Action;
import com.labbati.cando.model.CollectionAndActions;
import com.labbati.cando.model.EntityAndActions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleActionsProvider implements ActionsProvider {

    private final boolean includeDeniedActions;
    private final boolean includeInactiveConstraints;

    public SimpleActionsProvider(boolean includeDeniedActions, boolean includeInactiveConstraints) {
        this.includeDeniedActions = includeDeniedActions;
        this.includeInactiveConstraints = includeInactiveConstraints;
    }

    @Override
    public <T> CollectionAndActions<T> provideForCollection(
        Class<T> type,
        Collection<T> entities,
        CollectionActionsProvider<T> collectionActionsProvider,
        EntityActionsProvider<T>... entityActionsProviders
    ) {
        return new CollectionAndActions<>(
            type,
            entities.stream().map(e -> provideForEntity(e, entityActionsProviders)).collect(Collectors.toList()),
            collectionActionsProvider.provide(type, includeDeniedActions, includeInactiveConstraints)
        );
    }

    @Override
    public <T> EntityAndActions<T> provideForEntity(T entity, EntityActionsProvider<T>... entityActionsProviders) {
        List<Action> actions = new ArrayList<>();
        for (EntityActionsProvider<T> provider : entityActionsProviders) {
            actions.addAll(provider.provide(entity, includeDeniedActions, includeInactiveConstraints));
        }
        return new EntityAndActions<>(entity, actions);
    }
}
