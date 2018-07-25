package com.labbati.cando.provider;

import com.labbati.cando.Action;

import java.util.List;
import java.util.function.Function;


public interface CollectionActionsProvider<T> extends Function<Class<T>, List<Action>> {
}
