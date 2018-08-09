package com.labbati.cando.provider;

import com.labbati.cando.model.Reason;

import java.util.function.Function;

public class SimpleCollectionReasonProvider<T> implements CollectionReasonProvider<T> {

    private String code;

    private Function<Class<T>, Boolean> activator;

    private Function<Class<T>, Object> valueProvider;

    public SimpleCollectionReasonProvider(
        String code,
        Function<Class<T>, Boolean> activator,
        Function<Class<T>, Object> valueProvider
    ) {
        this.code = code;
        this.activator = activator;
        this.valueProvider = valueProvider;
    }

    @Override
    public Reason provide(Class<T> type) {
        return new Reason(code, activator.apply(type), valueProvider.apply(type));
    }
}
