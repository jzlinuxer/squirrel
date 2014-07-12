package org.squirrelframework.foundation.fsm.builder;

import org.squirrelframework.foundation.fsm.StateMachine;

/**
 * Created by kailianghe on 7/12/14.
 */
public interface MultiTransitionBuilder<T extends StateMachine<T, S, E, C>, S, E, C> {

    /**
     * Build transition source state.
     * @param stateId id of state
     * @return multi from clause builder
     */
    MultiFrom<T, S, E, C> from(S stateId);

    /**
     * Build transition source states.
     * @param stateIds id of states
     * @return single from clause builder
     */
    From<T, S, E, C> fromSome(S... stateIds);
}