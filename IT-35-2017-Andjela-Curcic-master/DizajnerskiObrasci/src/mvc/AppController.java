package mvc;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import commands.AddShapeCmd;
import dialogs.DlgCircle;
import dialogs.DlgDonut;
import dialogs.DlgHexagon;
import dialogs.DlgRectangle;

import java.awt.event.ActionEvent;

import shapes.Line;
import shapes.Point;

public class AppController {
	
	private AppModel model;
	private AppFrame frame;
	AddShapeCmd addShapeCmd;
	private Point firstPoint;
	
	
	private Color edgeColor, innerColor = Color.WHITE;
	
	
	public AppController(AppModel model, AppFrame frame) {
		
		this.model = model;
		this.frame = frame;
		
		this.innerColor = Color.WHITE;
		this.edgeColor = Color.WHITE;
	}
	
	public void state(MouseEvent e) {
		
		if(frame.getBtnShapePoint().isSelected()) {
			
			drawPoint(e);
		}
		if(frame.getBtnShapeLine().isSelected()) {
			drawLine(e);
		}
		if(frame.getBtnShapeCircle().isSelected()) {
			drawCircle(e);
		}
		if(frame.getBtnShapeRectangle().isSelected()) {
			drawRectangle(e);
		}
		if(frame.getBtnShapeDonut().isSelected()) {
			drawDonut(e);
		}
		if(frame.getBtnShapeHexagon().isSelected()) {
			drawHexagon(e);
		}
		if(frame.getBtnOperationSelect().isSelected()) {
			select(e);
		}
	}
	
	
	public void drawPoint(MouseEvent e) {
		
		Point mouseClick = new Point(e.getX(),e.getY());
		Point point = new Point(mouseClick.getX(),mouseClick.getY(),edgeColor);
		
		point.setEdgeColor(frame.getBtnColorEdge().getBackground());
		addShapeCmd = new AddShapeCmd(point,model);
		addShapeCmd.execute();
		frame.getView().repaint();
	
	}
	
	public void drawLine(MouseEvent e) {
		if(model.getStartPoint() == null) {
			model.setStartPoint(new Point(e.getX(),e.getY()));
		}
		else {
		Line line = new Line(model.getStartPoint(),new Point(e.getX(),e.getY()),edgeColor);
		line.setEdgeColor(frame.getBtnColorEdge().getBackground());
		addShapeCmd = new AddShapeCmd(line,model);
		addShapeCmd.execute();
		frame.getView().repaint();
		model.setStartPoint(null);
		}
		
	}
	
public void drawRectangle(MouseEvent e) {
	
		DlgRectangle dlgRectangle = new DlgRectangle();
		dlgRectangle.setPoint(new Point(e.getX(),e.getY()));
		dlgRectangle.setColors(frame.getBtnColorEdge().getBackground(), frame.getBtnColorInner().getBackground());
		dlgRectangle.setVisible(true);
		if(dlgRectangle.getRectangle()!= null)
		{	
			frame.getBtnColorEdge().setBackground(dlgRectangle.getEdgeColor());
			frame.getBtnColorInner().setBackground(dlgRectangle.getInnerColor());
			addShapeCmd = new AddShapeCmd(dlgRectangle.getRectangle(),model);
			addShapeCmd.execute();
			frame.getView().repaint();
		} 
		
	}
	
	public void drawCircle(MouseEvent e) {
		
		DlgCircle dlgCircle = new DlgCircle();
		dlgCircle.setPoint(new Point(e.getX(),e.getY()));
		dlgCircle.setColors(frame.getBtnColorEdge().getBackground(), frame.getBtnColorInner().getBackground());
		dlgCircle.setVisible(true);
		if(dlgCircle.getCircle()!= null)
		{	
			frame.getBtnColorEdge().setBackground(dlgCircle.getEdgeColor());
			frame.getBtnColorInner().setBackground(dlgCircle.getInnerColor());
			addShapeCmd = new AddShapeCmd(dlgCircle.getCircle(),model);
			addShapeCmd.execute();
			frame.getView().repaint();
		} 
	}
	
public void drawDonut(MouseEvent e) {
		
		DlgDonut dlgDonut = new DlgDonut();
		dlgDonut.setPoint(new Point(e.getX(),e.getY()));
		dlgDonut.setColors(frame.getBtnColorEdge().getBackground(), frame.getBtnColorInner().getBackground());
		dlgDonut.setVisible(true);
		if(dlgDonut.getDonut()!= null)
		{	
			frame.getBtnColorEdge().setBackground(dlgDonut.getEdgeColor());
			frame.getBtnColorInner().setBackground(dlgDonut.getInnerColor());
			addShapeCmd = new AddShapeCmd(dlgDonut.getDonut(),model);
			addShapeCmd.execute();
			frame.getView().repaint();
		} 
	}
public void drawHexagon(MouseEvent e) {
	
	DlgHexagon dlgHexagon = new DlgHexagon();
	dlgHexagon.setPoint(new Point(e.getX(),e.getY()));
	dlgHexagon.setColors(frame.getBtnColorEdge().getBackground(), frame.getBtnColorInner().getBackground());
	dlgHexagon.setVisible(true);
	if(dlgHexagon.getHexagon()!= null)
	{	
		frame.getBtnColorEdge().setBackground(dlgHexagon.getEdgeColor());
		frame.getBtnColorInner().setBackground(dlgHexagon.getInnerColor());
		addShapeCmd = new AddShapeCmd(dlgHexagon.getHexagon(),model);
		addShapeCmd.execute();
		frame.getView().repaint();
	} 
}

public void select(MouseEvent e) {
	
}


	
	
	

	public Color getEdgeColor() {
		return edgeColor;
	}

	

	public Color getInnerColor() {
		return innerColor;
	}

	
	
	
	

}
