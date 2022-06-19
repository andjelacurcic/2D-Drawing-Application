package dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;

import shapes.Point;
import shapes.Rectangle;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Color;
import java.awt.Dimension;

public class DlgRectangle extends JDialog {
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtHeight;
	private JTextField txtWidth;
	
	private Rectangle rectangle = null;
	private Color edgeColor = null;
	private Color innerColor = null;
	private JButton btnInnerColor = new JButton("");
	private JButton btnEdgeColor = new JButton("");
	
	private boolean isSelected = false;
	public DlgRectangle() {
		getContentPane().setBackground(Color.GRAY);
		
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300, 300));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 17, 18, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("X kordinata");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		txtX = new JTextField();
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 3;
		gbc_txtX.gridy = 2;
		getContentPane().add(txtX, gbc_txtX);
		txtX.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Y kordinata");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 3;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtY = new JTextField();
		txtY.setColumns(10);
		GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 5);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 3;
		gbc_txtY.gridy = 3;
		getContentPane().add(txtY, gbc_txtY);
		
		JLabel lblNewLabel_2 = new JLabel("Visina");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 4;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		GridBagConstraints gbc_txtHeight = new GridBagConstraints();
		gbc_txtHeight.insets = new Insets(0, 0, 5, 5);
		gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHeight.gridx = 3;
		gbc_txtHeight.gridy = 4;
		getContentPane().add(txtHeight, gbc_txtHeight);
		
		JLabel lblNewLabel_3 = new JLabel("Sirina");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 2;
		gbc_lblNewLabel_3.gridy = 5;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		GridBagConstraints gbc_txtWidth = new GridBagConstraints();
		gbc_txtWidth.insets = new Insets(0, 0, 5, 5);
		gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtWidth.gridx = 3;
		gbc_txtWidth.gridy = 5;
		getContentPane().add(txtWidth, gbc_txtWidth);
		
		JLabel lblNewLabel_4 = new JLabel("Boja ivice");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 7;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		
		GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
		btnEdgeColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "izaberite boju ivice", edgeColor);
				if(edgeColor==null) edgeColor = Color.BLACK;
				btnEdgeColor.setBackground(edgeColor);
			}
		});
		gbc_btnEdgeColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdgeColor.gridx = 3;
		gbc_btnEdgeColor.gridy = 7;
		getContentPane().add(btnEdgeColor, gbc_btnEdgeColor);
		
		JLabel lblNewLabel_5 = new JLabel("Boja unutrasnjosti");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 8;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		
		btnInnerColor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
		btnInnerColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "izaberite boju unutrasnjosti", innerColor);
				if(innerColor==null) innerColor = Color.WHITE;
				btnInnerColor.setBackground(innerColor);
			}
		});
		gbc_btnInnerColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInnerColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnInnerColor.gridx = 3;
		gbc_btnInnerColor.gridy = 8;
		getContentPane().add(btnInnerColor, gbc_btnInnerColor);
		
		JButton btnOk = new JButton("Potvrdi");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int newX = Integer.parseInt(txtX.getText());
					int newY = Integer.parseInt(txtY.getText());
					int newHeight = Integer.parseInt(txtHeight.getText());
					int newWidth = Integer.parseInt(txtWidth.getText());
					
					if(newX <0 || newY < 0 || newHeight < 1 || newWidth < 1) {
						JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke");
						return;
					}
					
					rectangle = new Rectangle(new Point(newX,newY), newHeight,newWidth,edgeColor,innerColor);
					rectangle.setSelected(isSelected);
					dispose();
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke!", "Greska!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		gbc_btnOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnOk.gridx = 3;
		gbc_btnOk.gridy = 9;
		getContentPane().add(btnOk, gbc_btnOk);
		
		JButton btnNotOk = new JButton("Odustani");
		GridBagConstraints gbc_btnNotOk = new GridBagConstraints();
		btnNotOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		gbc_btnNotOk.insets = new Insets(0, 0, 5, 5);
		gbc_btnNotOk.gridx = 4;
		gbc_btnNotOk.gridy = 9;
		getContentPane().add(btnNotOk, gbc_btnNotOk);
	}
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public void setRectangle(Rectangle rectangle) {
		txtX.setText("" + rectangle.getUpperLeftPoint().getX());
		txtY.setText("" + rectangle.getUpperLeftPoint().getY());
		txtHeight.setText("" + rectangle.getHeight());
		txtWidth.setText("" + rectangle.getWidth());
		edgeColor = rectangle.getEdgeColor();
		innerColor = rectangle.getInnerColor();
		isSelected = rectangle.isSelected();
		
		setColors(rectangle.getEdgeColor(),rectangle.getInnerColor());
	}
	public void setPoint(Point point) {
		txtX.setText("" + point.getX());
		txtY.setText("" + point.getY());
		
	}
	public void setColors(Color edgeColor, Color innerColor) {
		this.edgeColor = edgeColor;
		this.innerColor = innerColor;
		btnEdgeColor.setBackground(edgeColor);
		btnInnerColor.setBackground(innerColor);
	}
	public Color getEdgeColor() {
		return edgeColor;
	}
	
	public Color getInnerColor() {
		return innerColor;
	}
	

}
