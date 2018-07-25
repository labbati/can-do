package com.labbati.cando.builder;

public class ActionProviderBuilder {

    public static <T> CollectionActionProviderBuilder<T> onCollection(Class<T> type, String name) {
        return new CollectionActionProviderBuilder<>(type, name);
    }

    public static <T> EntityActionProviderBuilder<T> onEntity(Class<T> type, String name) {
        return new EntityActionProviderBuilder<>(type, name);
    }
}
