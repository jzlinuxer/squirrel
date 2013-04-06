package org.squirrelframework.foundation.fsm.builder;

import org.squirrelframework.foundation.fsm.MutableState;
import org.squirrelframework.foundation.fsm.StateMachine;

/**
 * State machine builder API.
 * 
 * @author Henry.He
 *
 * @param <T> The type of implemented state machine
 * @param <S> The type of implemented state
 * @param <E> The type of implemented event
 * @param <C> The type of implemented context
 */
public interface StateMachineBuilder<T extends StateMachine<T, S, E, C>, S, E, C> {
    TransitionBuilder<T, S, E, C> transition();
    
    /**
     * Define a new state in state machine model
     * @param stateId id of new state
     * @return defined new immutable state
     */
    MutableState<T, S, E, C> defineState(S stateId);
    
    /**
     * Define hierarchy states on parent state
     * 
     * @param parentStateId id of parent state.
     * @param childStateIds child states id of parent state. The first child state will be used as initial child state of parent state.
     */
    void defineHierachyOn(S parentStateId, S... childStateIds);
    
    /**
     * Define on entry actions for state
     * @param stateId the id of state
     * @return the builder to build state on entry actions
     */
    EntryExitActionBuilder<T, S, E, C> onEntry(S stateId);
    
    /**
     * Define on exit actions for state.
     * @param stateId the id of state
     * @return the builder to build state on exit actions
     */
    EntryExitActionBuilder<T, S, E, C> onExit(S stateId);
    
    /**
     * Create new state machine instance according to state machine definition 
     * @param initialStateId the id of state machine initial state
     * @param parent parent state machine
     * @param type the class type of state machine
     * @param isLeaf whether state machine has child state machine
     * @param extraParams other parameters for instantiate state machine
     * @return new state machine
     */
    T newStateMachine(S initialStateId, T parent, Class<?> type, boolean isLeaf, Object... extraParams);
}