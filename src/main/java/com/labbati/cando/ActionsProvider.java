package com.labbati.cando;

import java.util.List;

public interface ActionsProvider<T> {
    List<Action> getCollectionActions(Class<T> type, Iterable<T> entities);
    List<Action> getEntityActions(T entitY);
}
