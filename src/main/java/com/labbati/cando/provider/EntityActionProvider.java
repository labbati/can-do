package com.labbati.cando.provider;

import com.labbati.cando.Action;

import java.util.function.Function;


public interface EntityActionProvider<T> extends Function<T, Action> {
}
