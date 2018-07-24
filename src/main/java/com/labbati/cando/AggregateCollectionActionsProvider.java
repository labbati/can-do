package com.labbati.cando;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AggregateCollectionActionsProvider<T> implements CollectionActionsProvider<T> {

    private final CollectionActionProvider<T>[] actionsProviders;

    public AggregateCollectionActionsProvider(CollectionActionProvider<T>... actionProviders) {
        this.actionsProviders = actionProviders;
    }
    
    @Override
    public List<Action> apply(Class<T> type, Collection<T> entities) {
        return Stream.of(actionsProviders)
            .map(ap -> ap.apply(type, entities))
            .collect(Collectors.toList());
    }
}
