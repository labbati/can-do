package com.labbati.cando.provider;

import com.labbati.cando.model.Action;
import com.labbati.cando.model.Constraint;
import com.labbati.cando.model.Reason;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimpleEntityActionProvider<T> implements EntityActionProvider<T> {

    final private String name;

    final private Function<T, Boolean> allowEvaluator;

    final private List<EntityConstraintProvider<T>> constraintProviders;

    final private List<EntityReasonProvider<T>> reasonProviders;

    public SimpleEntityActionProvider(
        String name,
        Function<T, Boolean> allowEvaluator,
        List<EntityConstraintProvider<T>> constraintProviders,
        List<EntityReasonProvider<T>> reasonProviders
    ) {
        this.name = name;
        this.allowEvaluator = allowEvaluator;
        this.constraintProviders = constraintProviders;
        this.reasonProviders = reasonProviders;
    }

    @Override
    public Action provide(T entity, Boolean includeInactiveConstraints) {
        List<Constraint> constraints = constraintProviders.stream()
            .map(cp -> cp.provide(entity))
            .filter(c -> includeInactiveConstraints || c.isActive())
            .collect(Collectors.toList());

        Boolean isAllowed = allowEvaluator.apply(entity);

        List<Reason> reasons = isAllowed
            ? new ArrayList<>()
            : reasonProviders.stream()
            .map(rp -> rp.provide(entity))
            .collect(Collectors.toList());

        return new Action(name, isAllowed, constraints, reasons);
    }
}
