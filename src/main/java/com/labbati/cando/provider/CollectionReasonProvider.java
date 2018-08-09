package com.labbati.cando.provider;

import com.labbati.cando.model.Reason;

@FunctionalInterface
public interface CollectionReasonProvider<T> {

    Reason provide(Class<T> type);
}
