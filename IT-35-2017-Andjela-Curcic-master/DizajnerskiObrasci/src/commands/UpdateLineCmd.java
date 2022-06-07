package commands;

import shapes.Line;

public class UpdateLineCmd implements Command {

	private Line oldState;
	private Line newState;
	private Line original;
	
	public UpdateLineCmd(Line oldState, Line newState) {
		this.oldState=oldState;
		this.newState = newState;
		original =(Line)oldState.clone();
	}
	
	
	@Override
	public void execute() {
		oldState.getStartPoint().setX(newState.getStartPoint().getX());
		oldState.getStartPoint().setY(newState.getStartPoint().getY());
		oldState.getEndPoint().setX(newState.getEndPoint().getX());
		oldState.getEndPoint().setY(newState.getEndPoint().getY());
		oldState.setEdgeColor(newState.getEdgeColor());
		oldState.setSelected(newState.isSelected());
	}

	@Override
	public void unexecute() {
		oldState.getStartPoint().setX(original.getStartPoint().getX());
		oldState.getStartPoint().setY(original.getStartPoint().getY());
		oldState.getEndPoint().setX(original.getEndPoint().getX());
		oldState.getEndPoint().setY(original.getEndPoint().getY());
		oldState.setEdgeColor(original.getEdgeColor());
		oldState.setSelected(original.isSelected());
		
	}
	
	

}
