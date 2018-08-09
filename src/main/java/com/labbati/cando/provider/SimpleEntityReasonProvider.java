package com.labbati.cando.provider;

import com.labbati.cando.model.Reason;

import java.util.function.Function;

public final class SimpleEntityReasonProvider<T> implements EntityReasonProvider<T> {

    private String code;

    private Function<T, Boolean> activator;

    private Function<T, Object> valueProvider;

    public SimpleEntityReasonProvider(
        String code,
        Function<T, Boolean> activator,
        Function<T, Object> valueProvider
    ) {
        this.code = code;
        this.activator = activator;
        this.valueProvider = valueProvider;
    }

    @Override
    public Reason provide(T entity) {
        return new Reason(code, activator.apply(entity), valueProvider.apply(entity));
    }
}
