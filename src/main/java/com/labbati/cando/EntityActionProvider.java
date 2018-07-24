package com.labbati.cando;

import java.util.function.BiFunction;


interface EntityActionProvider<T> extends BiFunction<Class<T>, T, Action> {}
