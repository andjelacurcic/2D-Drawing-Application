package commands;

import adapter.HexagonAdapter;

public class UpdateHexagonCmd implements Command {

	private HexagonAdapter oldState;
	private HexagonAdapter newState;
	private HexagonAdapter original;
	private String cmdLog;
	
	
	public void setCmdLog(String cmdLog) {
		this.cmdLog = cmdLog;
	}

	public String getCmdLog() {
		return cmdLog;
	}
	
	
	public UpdateHexagonCmd(HexagonAdapter oldState, HexagonAdapter newState) {
		this.oldState = oldState;
		this.newState = newState;
		original = (HexagonAdapter) oldState.clone();
	}

	@Override
	public void execute() {
		oldState.getHexagon().setX(newState.getHexagon().getX());
		oldState.getHexagon().setY(newState.getHexagon().getY());
		oldState.getHexagon().setR(newState.getHexagon().getR());
		oldState.setEdgeColor(newState.getEdgeColor());
		oldState.setInnerColor(newState.getInnerColor());
		oldState.setSelected(newState.isSelected());
		cmdLog= "EXECUTE_UPDATE_" + original + "-->" + newState;
	}

	@Override
	public void unexecute() {
		oldState.getHexagon().setX(original.getHexagon().getX());
		oldState.getHexagon().setY(original.getHexagon().getY());
		oldState.getHexagon().setR(original.getHexagon().getR());
		oldState.setEdgeColor(original.getEdgeColor());
		oldState.setInnerColor(original.getInnerColor());
		oldState.setSelected(original.isSelected());
		cmdLog = "UNEXECUTE_UPDATE_" + newState + "-->" + original;
		
	}
	
	

}
