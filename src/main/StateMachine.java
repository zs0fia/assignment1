package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.metamodel.*;

public class StateMachine {
	private List<State> states = new ArrayList<State>();
	private State current;
	private State initial;
	private String currentEvent;
	private Map<String,Integer> integers = new HashMap<>();
	private Transition currentTransition;
	
	private State getState(String string) {
		List<State> result = new ArrayList<State>();
		result = states.stream().filter(s -> s.getName().equals(string)).toList();
		
		if(result.size() == 0) {
			State newState = new State(string);
			states.add(newState);
			return newState;
		}
		else {
			return result.get(0);
		}
	}

	public Machine build() {
		return new Machine(states, initial, integers); 
	}

	public StateMachine state(String string) {
		current = getState(string);
		return this;
	}

	public StateMachine initial() {
		initial = current;
		return this;
	}

	public StateMachine when(String string) {
		currentEvent = string;
		return this;
	}

	public StateMachine to(String string) {
		Transition t = new Transition(currentEvent,getState(string));
		current.addTransition(t);
		currentTransition = t;
		return this;
	}

	public StateMachine integer(String string) {
		integers.put(string, 0);
		return this;
	}

	public StateMachine set(String string, int i) {
		currentTransition.SetTheOperation("set");
		currentTransition.SetTheOperationVariable(string);
		currentTransition.SetTheOperationVariableValue(i);
		return this;
	}

	public StateMachine increment(String string) {
		currentTransition.SetTheOperation("increment");
		currentTransition.SetTheOperationVariable(string);
		return this;
	}

	public StateMachine decrement(String string) {
		currentTransition.SetTheOperation("decrement");
		currentTransition.SetTheOperationVariable(string);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		currentTransition.SetTheCondition("ifEquals");
		currentTransition.SetTheConditionVariable(string);
		currentTransition.SetTheConditionVariableValueExpected(i);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		currentTransition.SetTheCondition("ifGreaterThan");
		currentTransition.SetTheConditionVariable(string);
		currentTransition.SetTheConditionVariableValueExpected(i);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		currentTransition.SetTheCondition("ifLessThan");
		currentTransition.SetTheConditionVariable(string);
		currentTransition.SetTheConditionVariableValueExpected(i);
		return this;
	}
}