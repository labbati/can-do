package com.labbati.cando.provider;

import com.labbati.cando.Action;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregateCollectionActionsProvider<T> implements CollectionActionsProvider<T> {

    private final CollectionActionProvider<T>[] actionsProviders;

    public AggregateCollectionActionsProvider(CollectionActionProvider<T>... actionProviders) {
        this.actionsProviders = actionProviders;
    }

    @Override
    public List<Action> apply(Class<T> type) {
        return Stream.of(actionsProviders)
            .map(ap -> ap.apply(type))
            .collect(Collectors.toList());
    }
}
