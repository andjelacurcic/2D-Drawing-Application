package mvc;

import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import adapter.HexagonAdapter;
import commands.AddShapeCmd;
import commands.BringToBackCmd;
import commands.BringToFrontCmd;
import commands.Command;
import commands.DeleteShapesCmd;
import commands.ToBackCmd;
import commands.ToFrontCmd;
import commands.UpdateCircleCmd;
import commands.UpdateDonutCmd;
import commands.UpdateHexagonCmd;
import commands.UpdateLineCmd;
import commands.UpdatePointCmd;
import commands.UpdateRectangleCmd;
import dialogs.DlgCircle;
import dialogs.DlgDonut;
import dialogs.DlgHexagon;
import dialogs.DlgLine;
import dialogs.DlgPoint;
import dialogs.DlgRectangle;

import java.awt.event.ActionEvent;

import shapes.Circle;
import shapes.Donut;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import shapes.Shape;
import strategy.Context;
import strategy.FileSerialization;

public class AppController {
	
	private AppModel model;
	private AppFrame frame;
	AddShapeCmd addShapeCmd;
	private Point firstPoint;
	private Context context;
	private FileSerialization fileSerialization;
	
	
	private Color edgeColor, innerColor = Color.WHITE;
	
	
	public AppController(AppModel model, AppFrame frame) {
		
		this.model = model;
		this.frame = frame;
		
		this.fileSerialization = new FileSerialization(model);
		this.innerColor = Color.WHITE;
		this.edgeColor = Color.BLACK;
	}
	
	public void stateController(MouseEvent e) {
		state(e);
		frame.getView().repaint();
	}
	
	public void state(MouseEvent e) {
		
		if(frame.getStateFrame()=="edit") {
	
		if(frame.getBtnOperationSelect().isSelected()) {
			selectOperation(e);
		}
		}
		else if(frame.getStateFrame()=="draw") {
			frame.getBtnOperationDrawing().setSelected(true);
		model.getSelectedShapes().forEach(shape -> {
			shape.setSelected(false);
		});
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
		
		}
		
			
	}
	
	
	public void drawPoint(MouseEvent e) {
		
		Point mouseClick = new Point(e.getX(),e.getY());
		Point point = new Point(mouseClick.getX(),mouseClick.getY(),edgeColor);
		
		point.setEdgeColor(frame.getBtnColorEdge().getBackground());
		addShapeCmd = new AddShapeCmd(point,model);
		addShapeCmd.execute();
		model.getUndo().push(addShapeCmd);
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
		model.getUndo().push(addShapeCmd);
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
			model.getUndo().push(addShapeCmd);
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
			model.getUndo().push(addShapeCmd);
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
			model.getUndo().push(addShapeCmd);
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
		model.getUndo().push(addShapeCmd);
		addShapeCmd.execute();
		frame.getView().repaint();
	} 
}

public void selectOperation(MouseEvent e) {
	
	
	frame.getBtnsShapes().clearSelection();
	
	model.getShapes().forEach(shape -> {
		if(shape.contains(e.getX(), e.getY())) {
			if(shape.isSelected()) {
			shape.setSelected(false);
			}
			else {
				shape.setSelected(true);
				shape.isSelected();
			}
		}
	});
	
	/*model.getShapes().forEach(shape -> {
		if(shape.contains(e.getX(), e.getY())) {
			shape.setSelected(true);
			shape.isSelected();
		}
	});*/
	frame.getView().repaint();
	int index = model.getSelected();
	if(index == -1) return;
	
	Shape shape = model.getShape(index);
}

public void edit(ActionEvent e) {
	if(model.getSelectedShapes().size() > 1) {
		return;
	} else {
		int index = model.getSelected();
		Shape shape = model.getShape(index);
		
		if(shape instanceof Point) {
			DlgPoint dlgPoint = new DlgPoint();
			dlgPoint.setPoint((Point)shape);
			dlgPoint.setVisible(true);
			
			if(dlgPoint.getPoint()!=null) {
				frame.getBtnColorEdge().setBackground(dlgPoint.getEdgeColor());
				UpdatePointCmd updatePointCmd = new UpdatePointCmd((Point)shape,dlgPoint.getPoint());
				updatePointCmd.execute();
				model.getUndo().push(updatePointCmd);
				frame.getView().repaint();
			}
		}
		else if(shape instanceof Line) {
			DlgLine dlgLine = new DlgLine();
			dlgLine.setLine((Line)shape);
			dlgLine.setVisible(true);
		
			if(dlgLine.getLine()!= null) {
				frame.getBtnColorEdge().setBackground(dlgLine.getEdgeColor());
				UpdateLineCmd updateLineCmd = new UpdateLineCmd((Line)shape,dlgLine.getLine());
				updateLineCmd.execute();
				model.getUndo().push(updateLineCmd);
				frame.getView().repaint();
			}
		}
		else if(shape instanceof Rectangle) {
			DlgRectangle dlgRec= new DlgRectangle();
			dlgRec.setRectangle((Rectangle)shape);
			dlgRec.setVisible(true);
			if(dlgRec.getRectangle()!=null) {
				frame.getBtnColorEdge().setBackground(dlgRec.getEdgeColor());
				frame.getBtnColorInner().setBackground(dlgRec.getInnerColor());
				UpdateRectangleCmd updateRecCmd = new UpdateRectangleCmd((Rectangle)shape, dlgRec.getRectangle());
				updateRecCmd.execute();
				model.getUndo().push(updateRecCmd);
				frame.getView().repaint();
			}
		}
		else if(shape instanceof Circle) {
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.setCircle((Circle) shape);
			dlgCircle.setVisible(true);
			
			if(dlgCircle.getCircle() != null) {
				frame.getBtnColorEdge().setBackground(dlgCircle.getEdgeColor());
				frame.getBtnColorInner().setBackground(dlgCircle.getInnerColor());
				UpdateCircleCmd updateCircleCmd = new UpdateCircleCmd((Circle)shape,dlgCircle.getCircle());
				updateCircleCmd.execute();
				model.getUndo().push(updateCircleCmd);
				frame.getView().repaint();
			}
		}
		else if(shape instanceof Donut) {
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.setDonut((Donut) shape);
			dlgDonut.setVisible(true);
			
			if(dlgDonut.getDonut()!=null) {
				frame.getBtnColorEdge().setBackground(dlgDonut.getEdgeColor());
				frame.getBtnColorInner().setBackground(dlgDonut.getInnerColor());
				UpdateDonutCmd updateDonutCmd = new UpdateDonutCmd((Donut) shape,dlgDonut.getDonut());
				updateDonutCmd.execute();
				model.getUndo().push(updateDonutCmd);
				frame.getView().repaint();

			}
		}
		else if(shape instanceof HexagonAdapter) {
			DlgHexagon dlgHexagon  = new DlgHexagon();
			dlgHexagon.setHexagon((HexagonAdapter)shape);
			dlgHexagon.setVisible(true);
			if(dlgHexagon.getHexagon()!=null) {
				frame.getBtnColorEdge().setBackground(dlgHexagon.getEdgeColor());
				frame.getBtnColorInner().setBackground(dlgHexagon.getInnerColor());
				UpdateHexagonCmd updateHexagonCmd = new UpdateHexagonCmd((HexagonAdapter)shape,dlgHexagon.getHexagon());
				updateHexagonCmd.execute();
				model.getUndo().push(updateHexagonCmd);
				frame.getView().repaint();

			}
		}
	}
}


	public void delete(ActionEvent e) {
		System.out.println("delete");
		if(model.isEmpty())
			return;
		if(JOptionPane.showConfirmDialog(null, "Da li zaista zelite da obrisete?","Potvrda", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0) {
			DeleteShapesCmd deleteShapesCmd = new DeleteShapesCmd(model.getSelectedShapes(),model);
			deleteShapesCmd.execute();
			model.getUndo().push(deleteShapesCmd);
			frame.getView().repaint();
		}
	}
	
	public void toFront() {
		
			int index = model.getSelected();
			
			Shape selectedShape = model.getShape(index);
			System.out.println(selectedShape);
			if(index==model.getShapes().size()-1) return;
			ToFrontCmd toFront = new ToFrontCmd(selectedShape,model);
			toFront.execute();
			model.getUndo().push(toFront);
			frame.getView().repaint();
		
	}
	
	public void toBack() {
		int index = model.getSelected();
		
		Shape selectedShape = model.getShape(index);
		System.out.println(selectedShape);
		if(index==0) return;
		ToBackCmd toBack = new ToBackCmd(selectedShape,model);
		toBack.execute();
		model.getUndo().push(toBack);
		frame.getView().repaint();
	}
	
	public void bringToFront() {
		int index = model.getSelected();
		Shape selectedShape = model.getShape(index);
		if(index == model.getShapes().size()-1)
			return;
		BringToFrontCmd bringToFrontCmd = new BringToFrontCmd(selectedShape,model);
		bringToFrontCmd.execute();
		model.getUndo().push(bringToFrontCmd);
		frame.getView().repaint();
	}

	public void bringToBack() {
		int index = model.getSelected();
		Shape selectedShape = model.getShape(index);
		if(index == 0)
			return;
		BringToBackCmd bringToBackCmd = new BringToBackCmd(selectedShape,model);
		bringToBackCmd.execute();
		model.getUndo().push(bringToBackCmd);
		frame.getView().repaint();
		
	}
	
	public void undo() {
		if(model.getUndo().size()==-1)
			return;
		if(!model.getUndo().isEmpty()) {
			Command command = model.getUndo().pop();
			command.unexecute();
			model.getRedo().push(command);
			frame.getView().repaint();
		}
		
	}

	public void redo() {
		if(model.getRedo().size()==-1)
			return;
		if(!model.getRedo().isEmpty()) {
			Command command = model.getRedo().pop();
			command.execute();
			model.getUndo().push(command);
			frame.getView().repaint();
		}
		
		
	}

	public void openFile() {
		
		if(frame.getOpenFileChooser().showSaveDialog(null)== JFileChooser.APPROVE_OPTION) {
			
			if(frame.getOpenFileChooser().getFileFilter().getDescription()=="Crtez") {
				context = new Context(fileSerialization);
		
			}
			context.openFile(frame.getOpenFileChooser().getSelectedFile());
			frame.getView().repaint();
		
		}
		
		frame.getOpenFileChooser().setVisible(false);
		
	}

	public void saveFile() {
		if(!model.getShapes().isEmpty())
			frame.getSaveFileChooser().setFileFilter(frame.getDrawFilter());
		if(frame.getSaveFileChooser().showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			if(frame.getSaveFileChooser().getFileFilter().getDescription()=="Crtez") {
				context = new Context(fileSerialization);
			}
			context.saveFile(frame.getSaveFileChooser().getSelectedFile());
		}
		frame.getSaveFileChooser().setVisible(false);
		
	}

	

	public Color getEdgeColor() {
		return edgeColor;
	}

	

	public Color getInnerColor() {
		return innerColor;
	}

	

	

	

	

	
	
	
	

}
