package com.labbati.cando.model;

import java.util.ArrayList;
import java.util.List;

public class EntityAndActions<T> {

    private T entity;

    private List<Action> actions;

    public EntityAndActions(T entity, List<Action> actions) {
        this.entity = entity;
        this.actions = actions;
    }

    public EntityAndActions(T entity) {
        this(entity, new ArrayList<>());
    }

    public T getEntity() {
        return entity;
    }

    public List<Action> getActions() {
        return actions;
    }
}
