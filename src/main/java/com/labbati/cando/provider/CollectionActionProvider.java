package com.labbati.cando.provider;

import com.labbati.cando.Action;

import java.util.function.Function;


public interface CollectionActionProvider<T> extends Function<Class<T>, Action> {
}
