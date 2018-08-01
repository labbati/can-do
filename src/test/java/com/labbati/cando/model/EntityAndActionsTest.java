package com.labbati.cando.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EntityAndActionsTest {

    @Test
    public void it_construct_an_entity_with_actions() {
        DummyEntity entity = new DummyEntity();
        List<Action> actions = Arrays.asList(new Action("name", true));
        EntityAndActions<DummyEntity> entityAndActions = new EntityAndActions<>(entity, actions);

        assertThat(entityAndActions.getEntity(), is(entity));
        assertThat(entityAndActions.getActions(), is(actions));
    }

    private static class DummyEntity {}
}
