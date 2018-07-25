package com.labbati.cando;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CollectionAndActionsTest {

    @Test
    public void it_construct_a_collection_with_actions() {
        DummyEntity entity = new DummyEntity();
        List<EntityAndActions<DummyEntity>> entities = Arrays.asList(new EntityAndActions<>(entity));
        List<Action> actions = Arrays.asList(new Action("name", true));
        CollectionAndActions<DummyEntity> subject = new CollectionAndActions<>(DummyEntity.class, entities, actions);

        assertThat(subject.getEntitiesAndActions().size(), is(1));
        assertThat(subject.getEntitiesAndActions().get(0).getEntity(), is(entity));
        assertThat(subject.getActions(), equalTo(actions));
    }

    private static class DummyEntity {}
}
