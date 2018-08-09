package com.labbati.cando.provider;

import com.labbati.cando.model.Reason;

@FunctionalInterface
public interface EntityReasonProvider<T> {

    Reason provide(T entity);
}
