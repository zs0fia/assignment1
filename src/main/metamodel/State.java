package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {
	private String name;
	private List<Transition> trans = new ArrayList<>();
	
	public State(String name) {
		super();
		this.name = name;
	}

	public Object getName() {
		return name;
	}

	public List<Transition> getTransitions() {
		return trans;
	}

	public Transition getTransitionByEvent(String string) {
		List<Transition> result = trans.stream().filter(t -> t.getEvent().equals(string)).toList();
		if(result.size() > 0) {
			return result.get(0);
		}
		else {
			return null;
		}		
	}
	
	public void addTransition(Transition transition) {
		trans.add(transition);
	}
}