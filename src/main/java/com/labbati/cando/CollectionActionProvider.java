package com.labbati.cando;

import java.util.Collection;
import java.util.function.BiFunction;


interface CollectionActionProvider<T> extends BiFunction<Class<T>, Collection<T>, Action> {}
