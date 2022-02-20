package main.metamodel;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Machine {
	private List<State> states = new ArrayList<State>();
	private State initialState;	
	private Map<String,Integer> integers = new HashMap<>();
	
	public int GetIntegerValue(Object integerName){
		return integers.get(integerName).intValue();
	}
	
	public int SetIntegerValue(String integerName, int value){
		return integers.put(integerName, value);
	}
	
	public Machine(List<State> states, State initialState, Map<String,Integer> integers) {
		super();
		this.states.addAll(states);
		this.initialState = initialState;
		this.integers = integers;
	}

	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initialState;
	}

	public State getState(String string) {
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

	public int numberOfIntegers() {
		return integers.size();
	}

	public boolean hasInteger(String string) {
		if(integers.containsKey(string)) {
			return true;
		}else {
			return false;
		}
	}
}