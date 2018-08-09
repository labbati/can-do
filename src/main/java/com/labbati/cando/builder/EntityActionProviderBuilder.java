package com.labbati.cando.builder;

import com.labbati.cando.provider.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class EntityActionProviderBuilder<T> {

    private final Class<T> type;

    private final String name;

    private Function<T, Boolean> allowEvaluator = (type) -> true;

    private final Function<T, Object> alwaysNull = (type) -> null;

    private final List<EntityConstraintProvider<T>> constraints = new ArrayList<>();

    private final List<EntityReasonProvider<T>> reasons = new ArrayList<>();

    public EntityActionProviderBuilder(Class<T> type, String name) {
        this.name = name;
        this.type = type;
    }

    public EntityActionProviderBuilder<T> allowWhen(Function<T, Boolean> evaluator) {
        this.allowEvaluator = evaluator;
        return this;
    }

    public EntityActionProviderBuilder<T> denyWhen(Function<T, Boolean> evaluator) {
        this.allowEvaluator = (type) -> !evaluator.apply(type);
        return this;
    }

    public EntityActionProviderBuilder<T> withConstraint(String name, Object value) {
        return withConstraint(name, value, t -> true);
    }

    public EntityActionProviderBuilder<T> withConstraint(String name, Object value, Function<T, Boolean> activator) {
        return withConstraint(name, value, activator);
    }

    public EntityActionProviderBuilder<T> withConstraint(String name, Function<T, Object> valueProvider, Function<T, Boolean> activator) {
        constraints.add(new SimpleEntityConstraintProvider<>(name, valueProvider, activator));
        return this;
    }

    public EntityActionProviderBuilder<T> withReason(String code, Function<T, Boolean> activator, Function<T, Object> valueProvider) {
        reasons.add(new SimpleEntityReasonProvider<T>(code, activator, valueProvider));
        return this;
    }

    public EntityActionProviderBuilder<T> withReason(String name, Function<T, Boolean> activator) {
        return withReason(name, activator, alwaysNull);
    }

    public EntityActionProvider<T> build() {
        return new SimpleEntityActionProvider<>(name, allowEvaluator, constraints, reasons);
    }
}
