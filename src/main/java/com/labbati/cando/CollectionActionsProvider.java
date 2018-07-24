package com.labbati.cando;

import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;


public interface CollectionActionsProvider<T> extends BiFunction<Class<T>, Collection<T>, List<Action>> {}
