package com.labbati.cando.provider;

import com.labbati.cando.model.Action;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregateEntityActionsProvider<T> implements EntityActionsProvider<T> {

    private final EntityActionProvider<T>[] actionsProviders;

    public AggregateEntityActionsProvider(EntityActionProvider<T>... actionProviders) {
        this.actionsProviders = actionProviders;
    }

    @Override
    public List<Action> provide(T entity, Boolean includeDeniedActions, Boolean includeInactiveConstraints) {
        return Stream.of(actionsProviders)
            .map(ap -> ap.provide(entity, includeInactiveConstraints))
            .filter(action -> includeDeniedActions || action.isAllowed())
            .collect(Collectors.toList());
    }
}
