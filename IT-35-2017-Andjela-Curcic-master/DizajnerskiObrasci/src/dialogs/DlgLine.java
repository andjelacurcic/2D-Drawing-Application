package dialogs;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import shapes.Line;
import shapes.Point;

import javax.swing.JButton;

public class DlgLine extends JDialog{
	private JTextField txtFirstX;
	private JTextField txtFirstY;
	private JTextField txtSecondX;
	private JTextField txtSecondY;
	private JButton btnEdgeColor = new JButton("");
	
	private Line line = null;
	private Color edgeColor = null;
	private boolean isSelected = false;
	
	
	public DlgLine() {
		
		
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300, 300));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Prva X koordinata");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtFirstX = new JTextField();
		GridBagConstraints gbc_txtFirstX = new GridBagConstraints();
		gbc_txtFirstX.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstX.gridx = 5;
		gbc_txtFirstX.gridy = 1;
		panel.add(txtFirstX, gbc_txtFirstX);
		txtFirstX.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Prva Y koordinata");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtFirstY = new JTextField();
		txtFirstY.setColumns(10);
		GridBagConstraints gbc_txtFirstY = new GridBagConstraints();
		gbc_txtFirstY.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstY.gridx = 5;
		gbc_txtFirstY.gridy = 2;
		panel.add(txtFirstY, gbc_txtFirstY);
		
		JLabel lblNewLabel_2 = new JLabel("Druga X koordinata");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtSecondX = new JTextField();
		txtSecondX.setColumns(10);
		GridBagConstraints gbc_txtSecondX = new GridBagConstraints();
		gbc_txtSecondX.insets = new Insets(0, 0, 5, 0);
		gbc_txtSecondX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSecondX.gridx = 5;
		gbc_txtSecondX.gridy = 4;
		panel.add(txtSecondX, gbc_txtSecondX);
		
		JLabel lblNewLabel_3 = new JLabel("Druga Y koordinata");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 5;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtSecondY = new JTextField();
		txtSecondY.setColumns(10);
		GridBagConstraints gbc_txtSecondY = new GridBagConstraints();
		gbc_txtSecondY.insets = new Insets(0, 0, 5, 0);
		gbc_txtSecondY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSecondY.gridx = 5;
		gbc_txtSecondY.gridy = 5;
		panel.add(txtSecondY, gbc_txtSecondY);
		
		JLabel lblNewLabel_4 = new JLabel("Boja linije");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 6;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		
		GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
		btnEdgeColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				edgeColor = JColorChooser.showDialog(null, "Izaberi boju", edgeColor);
				if(edgeColor == null) edgeColor=Color.BLACK;
				btnEdgeColor.setBackground(edgeColor);
			}
		});
		gbc_btnEdgeColor.fill = GridBagConstraints.BOTH;
		gbc_btnEdgeColor.gridx = 5;
		gbc_btnEdgeColor.gridy = 6;
		panel.add(btnEdgeColor, gbc_btnEdgeColor);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Potvrdi");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int newFirstX= Integer.parseInt(txtFirstX.getText());
					int newFirstY = Integer.parseInt(txtFirstY.getText());
					int newSecondX= Integer.parseInt(txtSecondX.getText());
					int newSecondY = Integer.parseInt(txtSecondY.getText());
					if(newFirstX < 0 || newFirstY <0 || newSecondX<0 || newSecondY<0) {
						JOptionPane.showMessageDialog(null, "Uneli ste pogresne podatke!","Greska!", JOptionPane.ERROR_MESSAGE);
						return;
					}
					line = new Line(new Point(newFirstX,newFirstY),new Point(newSecondX,newSecondY),edgeColor);
					line.setSelected(isSelected);
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


	public Line getLine() {
		return line;
	}


	public void setLine(Line line) {
		txtFirstX.setText("" + line.getStartPoint().getX());
		txtFirstY.setText("" + line.getStartPoint().getY());
		txtSecondX.setText("" + line.getEndPoint().getX());
		txtSecondY.setText("" + line.getEndPoint().getY());
		edgeColor = line.getEdgeColor();
		isSelected = line.isSelected();
		
		btnEdgeColor.setBackground(line.getEdgeColor());
	}


	public Color getEdgeColor() {
		return edgeColor;
	}


	

}
