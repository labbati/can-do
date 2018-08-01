package com.labbati.cando.provider;

import com.labbati.cando.model.Action;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregateCollectionActionsProvider<T> implements CollectionActionsProvider<T> {

    private final CollectionActionProvider<T>[] actionsProviders;

    public AggregateCollectionActionsProvider(CollectionActionProvider<T>... actionProviders) {
        this.actionsProviders = actionProviders;
    }

    @Override
    public List<Action> provide(Class<T> type, Boolean includeDeniedActions, Boolean includeInactiveConstraints) {
        return Stream.of(actionsProviders)
            .map(ap -> ap.provide(type, includeInactiveConstraints))
            .filter(action -> includeDeniedActions || action.isAllowed())
            .collect(Collectors.toList());
    }
}
