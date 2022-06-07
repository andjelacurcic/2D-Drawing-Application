package commands;

import shapes.Circle;

public class UpdateCircleCmd implements Command{

	private Circle oldState;
	private Circle newState;
	private Circle original;
	
	
	
	public UpdateCircleCmd(Circle oldState, Circle newState) {
		
		this.oldState = oldState;
		this.newState = newState;
		original = (Circle) oldState.clone();
	}

	@Override
	public void execute() {
		oldState.getCenter().setX(newState.getCenter().getX());
		oldState.getCenter().setY(newState.getCenter().getY());
		oldState.setR(newState.getR());
		oldState.setEdgeColor(newState.getEdgeColor());
		oldState.setInnerColor(newState.getInnerColor());
		oldState.setSelected(newState.isSelected());
	}

	@Override
	public void unexecute() {
		oldState.getCenter().setX(original.getCenter().getX());
		oldState.getCenter().setY(original.getCenter().getY());
		oldState.setR(original.getR());
		oldState.setEdgeColor(original.getEdgeColor());
		oldState.setInnerColor(original.getInnerColor());
		oldState.setSelected(original.isSelected());
	}
	

}
