package dialogs;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import shapes.Circle;
import shapes.Donut;
import shapes.Point;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class DlgDonut extends JDialog{
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	private Donut donut = null;
	private Color edgeColor = null, innerColor = null;
	
	private boolean isSelected = false;
	
	private JButton btnEdgeColor = new JButton("");
	private JButton btnInnerColor = new JButton("");
	private JTextField txtInnerRadius;
	
	
	
	public DlgDonut() {
		
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300, 300));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 198, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("X kordinata");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtX = new JTextField();
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 0);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 5;
		gbc_txtX.gridy = 1;
		panel.add(txtX, gbc_txtX);
		txtX.setColumns(10);
		
		JLabel lblYKordinata = new JLabel("Y kordinata");
		lblYKordinata.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblYKordinata = new GridBagConstraints();
		gbc_lblYKordinata.insets = new Insets(0, 0, 5, 5);
		gbc_lblYKordinata.gridx = 1;
		gbc_lblYKordinata.gridy = 2;
		panel.add(lblYKordinata, gbc_lblYKordinata);
		
		txtY = new JTextField();
		txtY.setColumns(10);
		GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 0);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 5;
		gbc_txtY.gridy = 2;
		panel.add(txtY, gbc_txtY);
		
		JLabel lblRadius = new JLabel("Radijus");
		lblRadius.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblRadius = new GridBagConstraints();
		gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
		gbc_lblRadius.gridx = 1;
		gbc_lblRadius.gridy = 3;
		panel.add(lblRadius, gbc_lblRadius);
		
		txtRadius = new JTextField();
		txtRadius.setColumns(10);
		GridBagConstraints gbc_txtRadius = new GridBagConstraints();
		gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
		gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRadius.gridx = 5;
		gbc_txtRadius.gridy = 3;
		panel.add(txtRadius, gbc_txtRadius);
		
		JLabel lblUnutrasnjiRadijus = new JLabel("Unutrasnji radijus");
		lblUnutrasnjiRadijus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblUnutrasnjiRadijus = new GridBagConstraints();
		gbc_lblUnutrasnjiRadijus.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnutrasnjiRadijus.gridx = 1;
		gbc_lblUnutrasnjiRadijus.gridy = 4;
		panel.add(lblUnutrasnjiRadijus, gbc_lblUnutrasnjiRadijus);
		
		txtInnerRadius = new JTextField();
		txtInnerRadius.setColumns(10);
		GridBagConstraints gbc_txtInnerRadius = new GridBagConstraints();
		gbc_txtInnerRadius.insets = new Insets(0, 0, 5, 0);
		gbc_txtInnerRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInnerRadius.gridx = 5;
		gbc_txtInnerRadius.gridy = 4;
		panel.add(txtInnerRadius, gbc_txtInnerRadius);
		
		JLabel lblBojaIvice = new JLabel("Boja ivice");
		lblBojaIvice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
		gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaIvice.gridx = 1;
		gbc_lblBojaIvice.gridy = 5;
		panel.add(lblBojaIvice, gbc_lblBojaIvice);
		
		
		GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
		btnEdgeColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Izaberite boju ivice", edgeColor);
				if(edgeColor == null) edgeColor = Color.BLACK;
				btnEdgeColor.setBackground(edgeColor);
				}
		});
		gbc_btnEdgeColor.fill = GridBagConstraints.BOTH;
		gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdgeColor.gridx = 5;
		gbc_btnEdgeColor.gridy = 5;
		panel.add(btnEdgeColor, gbc_btnEdgeColor);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti");
		lblBojaUnutrasnjosti.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaUnutrasnjosti.gridx = 1;
		gbc_lblBojaUnutrasnjosti.gridy = 6;
		panel.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		
	
		GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
		gbc_btnInnerColor.insets = new Insets(0, 0, 5, 0);
		btnInnerColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				innerColor = JColorChooser.showDialog(null, "Izaberite boju unutrasnjosti", innerColor);
				if(innerColor == null) innerColor = Color.WHITE;
				btnInnerColor.setBackground(innerColor);
				}
		});
		gbc_btnInnerColor.fill = GridBagConstraints.BOTH;
		gbc_btnInnerColor.gridx = 5;
		gbc_btnInnerColor.gridy = 6;
		panel.add(btnInnerColor, gbc_btnInnerColor);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Potvrdi");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int newX = Integer.parseInt(txtX.getText());
					int newY = Integer.parseInt(txtY.getText());
					int newRadius = Integer.parseInt(txtRadius.getText());
					int newInnerRadius = Integer.parseInt(txtInnerRadius.getText());
					
					if( newRadius<newInnerRadius) {
						JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke");
						return;
					}
					
					if(newX <0 || newY<0 || newRadius<0 || newInnerRadius<0) {
						JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke");
						return;
					}
					donut = new Donut(new Point(newX,newY),newRadius,newInnerRadius,edgeColor,innerColor);
					donut.setSelected(isSelected);
					dispose();
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke");
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



	public Donut getDonut() {
		return donut;
	}



	public void setDonut(Donut donut) {
		txtX.setText("" + donut.getCenter().getX());
		txtY.setText("" + donut.getCenter().getY());
		txtRadius.setText("" + donut.getR());
		txtInnerRadius.setText("" + donut.getInnerRadius());
		edgeColor = donut.getEdgeColor();
		innerColor = donut.getInnerColor();
		isSelected = donut.isSelected();
		setColors(donut.getEdgeColor(),donut.getInnerColor());
	}



	public JButton getBtnEdgeColor() {
		return btnEdgeColor;
	}



	public void setBtnEdgeColor(JButton btnEdgeColor) {
		this.btnEdgeColor = btnEdgeColor;
	}



	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}



	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
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



	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}



	public Color getInnerColor() {
		return innerColor;
	}



	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
}
