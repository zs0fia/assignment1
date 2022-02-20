package main.metamodel;

public class Transition {
	private String event;
	private State to;	
	private String operation = "";
	private String operationVariable = "";
	private int operationVariableValue = 0;
	private String condition = "";
	private String conditionVariable = "";
	private int conditionVariableValueExpected = 0;

	public Transition(String event, State to) {
		super();
		this.event = event;
		this.to = to;
	}
	
	public Object getEvent() {
		return event;
	}

	public State getTarget() {
		return to;
	}
	
	public String getOperation() {
		return operation;
	}
	
	public int getOperationVariableValue() {
		return operationVariableValue;
	}

	public boolean hasSetOperation() {
		if(operation == "set") {
			return true;
		}
		return false;
	}

	public boolean hasIncrementOperation() {
		if(operation == "increment") {
			return true;
		}
		return false;
	}

	public boolean hasDecrementOperation() {
		if(operation == "decrement") {
			return true;
		}
		return false;
	}

	public Object getOperationVariableName() {
		return operationVariable;
	}

	public boolean isConditional() {
		if(condition == "ifEquals" || condition == "ifGreaterThan" 
				|| condition == "ifLessThan") {
			return true;
		}
		return false;
	}

	public Object getConditionVariableName() {
		return conditionVariable;
	}

	public Integer getConditionComparedValue() {
		return conditionVariableValueExpected;
	}

	public boolean isConditionEqual() {
		if(condition == "ifEquals") {
			return true;
		}
		return false;
	}

	public boolean isConditionGreaterThan() {
		if(condition == "ifGreaterThan") {
			return true;
		}
		return false;
	}

	public boolean isConditionLessThan() {
		if(condition == "ifLessThan") {
			return true;
		}
		return false;
	}

	public boolean hasOperation() {
		if(operation != "") {
			return true;
		}
		return false;
	}
	
	public void SetTheOperation(String operation) {
		this.operation = operation;
	}
	
	public void SetTheCondition(String condition) {
		this.condition = condition;
	}
	
	public void SetTheOperationVariable(String operationVariable) {
		this.operationVariable = operationVariable;
	}
	
	public void SetTheOperationVariableValue(int operationVariableValue) {
		this.operationVariableValue = operationVariableValue;
	}
	
	public void SetTheConditionVariable(String conditionVariable) {
		this.conditionVariable = conditionVariable;
	}
	
	public void SetTheConditionVariableValueExpected(int conditionVariableValueExpected) {
		this.conditionVariableValueExpected = conditionVariableValueExpected;
	}
}