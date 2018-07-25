package com.labbati.cando;

import java.util.List;

public class CollectionAndActions<T> {
    private Class<T> type;
    private List<EntityAndActions<T>> entitiesAndActions;
    private List<Action> actions;

    public CollectionAndActions(Class<T> type, List<EntityAndActions<T>> entitiesAndActions, List<Action> actions) {
        this.type = type;
        this.entitiesAndActions = entitiesAndActions;
        this.actions = actions;
    }

    public List<EntityAndActions<T>> getEntitiesAndActions() {
        return entitiesAndActions;
    }

    public List<Action> getActions() {
        return actions;
    }
}
