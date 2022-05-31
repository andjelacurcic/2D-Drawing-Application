package dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import shapes.Point;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgPoint extends JDialog {
	private JTextField txtX;
	private JTextField txtY;
	
	private Point point = null;
	private Color edgeColor = null;
	
	private boolean isSelected = false;
	private JButton btnEdgeColor = new JButton("");
	
	
	public DlgPoint() {
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setMinimumSize(new Dimension(200, 250));
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		
		
		JLabel lblNewLabel = new JLabel("X kordinata");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		txtX = new JTextField();
		panel.add(txtX);
		txtX.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Y kordinata");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		panel.add(lblNewLabel_1);
		
		txtY = new JTextField();
		panel.add(txtY);
		txtY.setColumns(10);
		
		JLabel lblEdgeColor = new JLabel("Boja");
		lblEdgeColor.setFont(new Font("Verdana", Font.BOLD, 15));
		panel.add(lblEdgeColor);
		
		
		panel.add(btnEdgeColor);
		btnEdgeColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Izaberi boju", edgeColor);
				if(edgeColor == null) edgeColor=Color.BLACK;
				btnEdgeColor.setBackground(edgeColor);
			}
		});
		panel.add(btnEdgeColor);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		
		JButton btnOk = new JButton("Potvrdi");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int newX= Integer.parseInt(txtX.getText());
					int newY = Integer.parseInt(txtY.getText());
					
					if(newX < 0 || newY <0) {
						JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke!","Greska!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					point = new Point(newX,newY,edgeColor);
					point.setSelected(isSelected);
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke!","Greska!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1.add(btnOk);
		
		JButton btnNotOk = new JButton("Odustani");
		btnNotOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnNotOk);
	}


	public Point getPoint() {
		return point;
	}


	public void setPoint(Point point) {
		txtX.setText("" + point.getX());
		txtY.setText("" + point.getY());
		edgeColor = point.getEdgeColor();
		isSelected = point.isSelected();
		
		btnEdgeColor.setBackground(point.getEdgeColor());
	}


	public Color getEdgeColor() {
		return edgeColor;
	}


	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}
	
	

}
