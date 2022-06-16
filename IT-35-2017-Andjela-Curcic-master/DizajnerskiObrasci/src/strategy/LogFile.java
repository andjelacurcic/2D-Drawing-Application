package strategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

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
import mvc.AppController;
import mvc.AppFrame;
import mvc.AppModel;
import shapes.Circle;
import shapes.Donut;
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import shapes.Shape;

import java.awt.Color;

public class LogFile implements Strategy {

	private AppController controller;
	private AppModel model;
	private AppFrame frame;
	private BufferedReader reader;
	private BufferedWriter writer;
	
	
	
	
	public LogFile(AppController controller, AppModel model, AppFrame frame) {
	
		this.controller = controller;
		this.model = model;
		this.frame = frame;
	}

	
	
	@Override
	public void saveFile(File file) {
		try {
			writer = new BufferedWriter(new FileWriter(file + ".log"));
			DefaultListModel<String> dlm = frame.getDefaultListModel();
			for(int i=0;i<dlm.size();i++) {
				writer.write(dlm.getElementAt(i));
				writer.newLine();
			}
			writer.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void openFile(File file) {
		try {
			reader = new BufferedReader(new FileReader(file));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void readCommand() {
		try {
			Command command;
			int index;
			String operation = reader.readLine();
			
			if(operation == null)
			{
				frame.getBtnReadCommand().setEnabled(false);
				return;
			}
			
			String[] cmdOperation = operation.split("_");
			
			if(cmdOperation[0].equals("EXECUTE")) {
				switch(cmdOperation[1]) {
				case "ADD":
					command = new AddShapeCmd(parseShape(cmdOperation[2]),model);
					command.execute();
					controller.getLog().addElement(((AddShapeCmd)command).getCmdLog());
					model.getUndo().push(command);
					break;
				case "UPDATE":
					String[] arrayOfShapes;
					
					if(cmdOperation[2].startsWith("Point")) {
						arrayOfShapes = cmdOperation[2].split("-->");
						Point oldState = parsePoint(arrayOfShapes[0]);
						Point newState = parsePoint(arrayOfShapes[1]);
						System.out.println(oldState);
						System.out.println(newState);
						
						index = model.getIndex(oldState);
						command = new UpdatePointCmd((Point)model.getShape(index),newState);
						command.execute();
						controller.getLog().addElement(((UpdatePointCmd)command).getCmdLog());
						model.getUndo().push(command);
						
					}

					else if(cmdOperation[2].startsWith("Line")) {
						arrayOfShapes = cmdOperation[2].split("-->");
						Line oldState = parseLine(arrayOfShapes[0]);
						Line newState = parseLine(arrayOfShapes[1]);
						
						index = model.getIndex(oldState);
						command = new UpdateLineCmd((Line)model.getShape(index),newState);
						command.execute();
						controller.getLog().addElement(((UpdateLineCmd)command).getCmdLog());
						model.getUndo().push(command);

					}
					else if(cmdOperation[2].startsWith("Circle")) {
						arrayOfShapes = cmdOperation[2].split("-->");
						Circle oldState = parseCircle(arrayOfShapes[0]);
						Circle newState = parseCircle(arrayOfShapes[1]);
						index = model.getIndex(oldState);
						command = new UpdateCircleCmd((Circle)model.getShape(index),newState);
						command.execute();
						controller.getLog().addElement(((UpdateCircleCmd)command).getCmdLog());
						model.getUndo().push(command);
					}
					
					
					else if(cmdOperation[2].startsWith("Donut")) {
						arrayOfShapes = cmdOperation[2].split("-->");
						Donut oldState = parseDonut(arrayOfShapes[0]);
						Donut newState = parseDonut(arrayOfShapes[1]);
						
						index = model.getIndex(oldState);
						command = new UpdateDonutCmd((Donut)model.getShape(index),newState);
						command.execute();
						controller.getLog().addElement(((UpdateDonutCmd)command).getCmdLog());
						model.getUndo().push(command);

					}
					else if(cmdOperation[2].startsWith("Rectangle")) {
						arrayOfShapes = cmdOperation[2].split("-->");
						Rectangle oldState = parseRectangle(arrayOfShapes[0]);
						Rectangle newState = parseRectangle(arrayOfShapes[1]);
			
						index = model.getIndex(oldState);
						command = new UpdateRectangleCmd((Rectangle)model.getShape(index),newState);
						command.execute();
						controller.getLog().addElement(((UpdateRectangleCmd)command).getCmdLog());
						model.getUndo().push(command);

					}
					else if(cmdOperation[2].startsWith("Hexagon")) {
						arrayOfShapes = cmdOperation[2].split("-->");
						HexagonAdapter oldState = parseHexagon(arrayOfShapes[0]);
						HexagonAdapter newState = parseHexagon(arrayOfShapes[1]);
						
						index = model.getIndex(oldState);
						command = new UpdateHexagonCmd((HexagonAdapter)model.getShape(index),newState);
						command.execute();
						controller.getLog().addElement(((UpdateHexagonCmd)command).getCmdLog());
						model.getUndo().push(command);

					} break;
					
				case "DELETE":
					String shapes = cmdOperation[2].replace("[", "").replace( "]","");
					ArrayList<Shape> shapesForDelete = new ArrayList<Shape>();
					String[] s = shapes.split(",");
					
					for(int i = 0;i<s.length;i++) {
						shapesForDelete.add(parseShape(s[i].trim()));
					}
					command = new DeleteShapesCmd((ArrayList)shapesForDelete, model);
					command.execute();
					controller.getLog().addElement(((DeleteShapesCmd)command).getCmdLog());
					model.getUndo().push(command);
					break;
				
				case "BRING-TO-BACK":
					index = model.getIndex(parseShape(cmdOperation[2]));
					command = new BringToBackCmd(model.getShape(index),model);
					command.execute();
					controller.getLog().addElement(((BringToBackCmd)command).getCmdLog());
					model.getUndo().push(command);
					break;
				case "BRING-TO-FRONT":
					index = model.getIndex(parseShape(cmdOperation[2]));
					command = new BringToFrontCmd(model.getShape(index),model);
					command.execute();
					controller.getLog().addElement(((BringToFrontCmd)command).getCmdLog());
					model.getUndo().push(command);
					break;
				case "TO-FRONT":
					index = model.getIndex(parseShape(cmdOperation[2]));
					command = new ToFrontCmd(model.getShape(index),model);
					command.execute();
					controller.getLog().addElement(((ToFrontCmd)command).getCmdLog());
					model.getUndo().push(command);
					break;
				case "TO-BACK":
					index = model.getIndex(parseShape(cmdOperation[2]));
					command = new ToBackCmd(model.getShape(index),model);
					command.execute();
					controller.getLog().addElement(((ToBackCmd)command).getCmdLog());
					model.getUndo().push(command);
					break;
				
				}
				
			}
			
			else if(cmdOperation[0].equals("UNEXECUTE")) {
				switch(cmdOperation[1]) {
				case "ADD":
					controller.undo();
					break;
				case "UPDATE":
					controller.undo();
					break;
				case "DELETE":
					controller.undo();
					break;
				case "BRING-TO-BACK":
					controller.undo();
					break;
				case "BRING-TO-FRONT":
					controller.undo();
					break;
				case "TO-BACK":
					controller.undo();
					break;
				case "TO-FRONT":
					controller.undo();
					break;
				}
			}
				
			else if(cmdOperation[0].equals("SELECT")) {
				String e = cmdOperation[2];
				String[] pointForSelect = e.split("\\|");
				int x = Integer.parseInt(pointForSelect[0].replace("(", ""));
				int y = Integer.parseInt(pointForSelect[1].replace(")", ""));
				controller.selectDeselectShapeFormLog(x,y);

			}
			else if(cmdOperation[0].equals("DESELECT")) {
				String e = cmdOperation[2];
				e.replace("(", "").replace(")", "");
				String[] pointForDeselect = e.split("\\|");
				int x = Integer.parseInt(pointForDeselect[0].replace("(", ""));
				int y = Integer.parseInt(pointForDeselect[1].replace(")", ""));
				controller.selectDeselectShapeFormLog(x,y);
			}
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
	}
	
	public Shape parseShape(String cmd) {
		if(cmd.startsWith("Point")) return parsePoint(cmd);
		else if(cmd.startsWith("Line")) return parseLine(cmd);
		else if(cmd.startsWith("Rectangle"))	return parseRectangle(cmd);
		else if(cmd.startsWith("Circle")) return parseCircle(cmd);
		else if(cmd.startsWith("Donut")) return parseDonut(cmd);
		else if(cmd.startsWith("Hexagon")) return parseHexagon(cmd);
		else return null;
	}
	
	private Point parsePoint(String shape) {
		shape = shape.replace("Point(","").replace(")", "");
		
		String[] params = shape.split("\\|");
		int x = Integer.parseInt(params[0]);
		int y = Integer.parseInt(params[1]);
		Color edgeColor = Color.decode(params[2].replace("EdgeColor(","").replace(")", ""));
		return new Point(x,y,edgeColor);
	}
	
	private Line parseLine(String shape) {
		
		shape = shape.replace("Line(X1", "").replace(")","");
		
		String[] params = shape.split("\\|");
		int x1 = Integer.parseInt(params[0]);
		int y1 = Integer.parseInt(params[1].replace("Y1", ""));
		int x2 = Integer.parseInt(params[2].replace("X2", ""));
		int y2 = Integer.parseInt(params[3].replace("Y2", ""));
		Color edgeColor = Color.decode(params[4].replace("EdgeColor(",""));
		
		return new Line(new Point(x1,y1), new Point(x2,y2), edgeColor);
		
		
	}
	
	private Circle parseCircle(String shape) {
		shape = shape.replace("Circle Center(", "").replace(")", "");
		
		String [] params = shape.split("\\|");
		
		int x = Integer.parseInt(params[0]);
		int y = Integer.parseInt(params[1]);
		int r = Integer.parseInt(params[2].replace("Radius(", ""));
		
		Color edgeColor = Color.decode(params[3].replace("EdgeColor(", ""));
		Color innerColor = Color.decode(params[4].replace("InnerColor(", ""));
		
		return new Circle(new Point(x, y), r, edgeColor, innerColor);
	}
	
	private Donut parseDonut(String shape) {
		shape = shape.replace("Donut Center(", "").replace(")", "");
		String[] params = shape.split("\\|");
		
		int x = Integer.parseInt(params[0]);
		int y = Integer.parseInt(params[1]);
		int r = Integer.parseInt(params[2].replace("Radius(", ""));
		int ir = Integer.parseInt(params[3].replace("InnerRadius(", ""));
		Color  edgeColor = Color.decode(params[4].replace("EdgeColor(", ""));
		Color  innerColor = Color.decode(params[5].replace("InnerColor(", ""));
	
		return new Donut(new Point(x,y), r,ir, edgeColor,innerColor);
	}
	
	
	private Rectangle parseRectangle(String shape) {
		shape = shape.replace("Rectangle UpperLeftPoint(", "").replace(")", "");
		String[] params = shape.split("\\|");
		
		int x = Integer.parseInt(params[0]);
		int y = Integer.parseInt(params[1]);
		int width = Integer.parseInt(params[2].replace("Width(", ""));
		int height = Integer.parseInt(params[3].replace("Height(", ""));
		Color edgeColor = Color.decode(params[4].replace("EdgeColor(", ""));
		Color innerColor = Color.decode(params[5].replace("InnerColor(", ""));
		return new Rectangle(new Point(x,y),height,width,edgeColor,innerColor);
		
	}
	
	private HexagonAdapter parseHexagon(String shape) {
		shape = shape.replace("Hexagon Center(", "").replace(")", "");
		String[] params = shape.split("\\|");
		
		int x = Integer.parseInt(params[0]);
		int y = Integer.parseInt(params[1]);
		int r = Integer.parseInt(params[2].replace("Radius(", ""));
		Color  edgeColor = Color.decode(params[3].replace("EdgeColor(", ""));
		Color  innerColor = Color.decode(params[4].replace("InnerColor(", ""));
	
		return new HexagonAdapter(new Point(x,y), r, edgeColor,innerColor);
	}
	
	
}
