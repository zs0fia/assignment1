package main;

import java.util.List;
import main.metamodel.*;

public class MachineInterpreter {
	private State currentState;
	private Machine machine;

	public void run(Machine m) {
		machine = m;
		currentState = m.getInitialState();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void processEvent(String string) {
		
		List<Transition> transitions = currentState.getTransitions().stream().filter(t -> t.getEvent() == string).toList();
		
		if(transitions.isEmpty()) {
			return;
		}
		
		for(Transition t: transitions) {
			if(!t.isConditional()) {
				if(t.hasOperation()) {
					switch(t.getOperation()) {
					case "increment": {
						int val = machine.GetIntegerValue(t.getOperationVariableName().toString()) +1;
						machine.SetIntegerValue(t.getOperationVariableName().toString(), val);
						break;
					}					
					case "decrement": {
						int val = machine.GetIntegerValue(t.getOperationVariableName().toString()) -1;
						machine.SetIntegerValue(t.getOperationVariableName().toString(), val);
						break;
					}
					case "set": {
						machine.SetIntegerValue(t.getOperationVariableName().toString(), t.getOperationVariableValue());
						break;}}						
				}
				currentState = t.getTarget();
				return;			
			}
			else if((t.isConditionEqual() && t.getConditionComparedValue() == getInteger(t.getConditionVariableName()))
					||(t.isConditionGreaterThan() && t.getConditionComparedValue() < getInteger(t.getConditionVariableName()))
					||(t.isConditionLessThan() && t.getConditionComparedValue() > getInteger(t.getConditionVariableName()))){
					if(t.hasOperation()) {
						switch(t.getOperation()) {
						case "increment": {
							int val = getInteger(t.getOperationVariableName());
							machine.SetIntegerValue(t.getOperationVariableName().toString(), val + 1);
							break;
						}
						case "decrement": {
							int val = getInteger(t.getOperationVariableName());
							machine.SetIntegerValue(t.getOperationVariableName().toString(), val - 1);
							break;
						}
						case "set": {
							machine.SetIntegerValue(t.getOperationVariableName().toString(), t.getOperationVariableValue());
							break;
						}}
					}
					currentState = t.getTarget();
					return;
				}
		}
	}
	
	public int getInteger(Object string) {
		return machine.GetIntegerValue(string);
	}
}