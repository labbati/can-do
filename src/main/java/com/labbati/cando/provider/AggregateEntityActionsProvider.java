package com.labbati.cando.provider;

import com.labbati.cando.Action;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregateEntityActionsProvider<T> implements EntityActionsProvider<T> {

    private final EntityActionProvider<T>[] actionsProviders;

    public AggregateEntityActionsProvider(EntityActionProvider<T>... actionProviders) {
        this.actionsProviders = actionProviders;
    }

    @Override
    public List<Action> apply(T entity) {
        return Stream.of(actionsProviders)
            .map(ap -> ap.apply(entity))
            .collect(Collectors.toList());
    }
}
