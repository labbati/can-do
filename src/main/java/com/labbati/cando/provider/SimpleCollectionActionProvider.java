package com.labbati.cando.provider;

import com.labbati.cando.model.Action;
import com.labbati.cando.model.Constraint;
import com.labbati.cando.model.Reason;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimpleCollectionActionProvider<T> implements CollectionActionProvider<T> {

    private final String name;

    private final Function<Class<T>, Boolean> allowEvaluator;

    private final List<CollectionConstraintProvider<T>> constraintProviders;
    
    private final List<CollectionReasonProvider<T>> reasonProviders;

    public SimpleCollectionActionProvider(
        String name,
        Function<Class<T>, Boolean> allowEvaluator,
        List<CollectionConstraintProvider<T>> constraintProviders,
        List<CollectionReasonProvider<T>> reasonProviders
    ) {
        this.name = name;
        this.allowEvaluator = allowEvaluator;
        this.constraintProviders = constraintProviders;
        this.reasonProviders = reasonProviders;
    }

    @Override
    public Action provide(Class<T> type, Boolean includeInactiveConstraints) {
        List<Constraint> constraints = constraintProviders.stream()
            .map(cp -> cp.provide(type))
            .filter(c -> includeInactiveConstraints || c.isActive())
            .collect(Collectors.toList());

        Boolean isAllowed = allowEvaluator.apply(type);

        // Reasons are only added when the action is not allowed
        List<Reason> reasons = isAllowed
            ? new ArrayList<>()
            : reasonProviders.stream()
                .map(rp -> rp.provide(type))
                .collect(Collectors.toList());

        return new Action(name, allowEvaluator.apply(type), constraints, reasons);
    }
}
