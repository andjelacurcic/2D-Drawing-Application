package strategy;

import java.io.File;

public class Context implements Strategy {

	private Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy=strategy;
	}
	
	@Override
	public void saveFile(File file) {
		strategy.saveFile(file);
		
	}

	@Override
	public void openFile(File file) {
		strategy.openFile(file);
	}
	
}


