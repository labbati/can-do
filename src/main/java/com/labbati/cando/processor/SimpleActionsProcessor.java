package com.labbati.cando.processor;

import com.labbati.cando.Action;
import com.labbati.cando.CollectionAndActions;
import com.labbati.cando.EntityAndActions;
import com.labbati.cando.provider.CollectionActionsProvider;
import com.labbati.cando.provider.EntityActionsProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleActionsProcessor implements ActionsProcessor{

    private final boolean includeDeniedActions;
    private final boolean includeInactiveContraints;

    public SimpleActionsProcessor() {
        this(true, false);
    }

    public SimpleActionsProcessor(boolean includeDeniedActions, boolean includeInactiveContraints) {
        this.includeDeniedActions = includeDeniedActions;
        this.includeInactiveContraints = includeInactiveContraints;
    }

    @Override
    public <T> CollectionAndActions<T> processCollection(
        Class<T> type,
        Collection<T> entities,
        CollectionActionsProvider<T> collectionActionsProvider,
        EntityActionsProvider<T>... entityActionsProviders
    ) {
        return new CollectionAndActions<>(
            type,
            entities.stream().map(e -> processEntity(e, entityActionsProviders)).collect(Collectors.toList()),
            collectionActionsProvider.apply(type)
        );
    }

    @Override
    public <T> EntityAndActions<T> processEntity(T entity, EntityActionsProvider<T>... entityActionsProviders) {
        List<Action> actions = new ArrayList<>();
        for (EntityActionsProvider<T> provider : entityActionsProviders) {
            actions.addAll(provider.apply(entity));
        }
        return new EntityAndActions<>(entity, actions);
    }
}
