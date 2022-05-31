package mvc;

import javax.swing.JPanel;

import shapes.Shape;

import java.awt.Color;
import java.awt.Graphics;

public class AppView  extends JPanel{
	
	private AppModel model;
	private Shape shape;
	
	public void setModel(AppModel model) {
		this.model=model;
	}
	
	public AppView() {
		setBackground(Color.WHITE);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if(model != null) {
			model.getShapes().forEach(shape -> shape.draw(g));
		}
		
		
	}

}
