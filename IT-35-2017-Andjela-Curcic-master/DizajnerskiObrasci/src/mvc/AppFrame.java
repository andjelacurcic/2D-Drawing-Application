package mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;


import javax.swing.JToggleButton;

import javax.swing.JList;

import javax.swing.filechooser.FileNameExtensionFilter;



import javax.swing.JColorChooser;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;


import java.awt.Color;


import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AppFrame extends JFrame {
	
	private AppView view = new AppView();
	private JPanel contentPane;
	
	private ButtonGroup btnsOperation = new ButtonGroup();
	private ButtonGroup btnsShapes = new ButtonGroup();
	private JToggleButton btnShapePoint = new JToggleButton("Tacka");
	private JToggleButton btnShapeLine = new JToggleButton("Linija");
	private JToggleButton btnShapeCircle = new JToggleButton("Krug");
	private JToggleButton btnShapeRectangle = new JToggleButton("Pravougaonik");
	private JToggleButton btnShapeDonut = new JToggleButton("Krofna");
	private JToggleButton btnShapeHexagon = new JToggleButton("Sestougao");
	private JButton btnColorEdge = new JButton("Boja ivice");
	
	private JButton btnColorInner = new JButton("Boja unutrasnjosti");
	private JToggleButton btnOperationDrawing = new JToggleButton("Crtaj");
	private JToggleButton btnOperationSelect = new JToggleButton("Selektuj");
	private JButton btnEdit = new JButton("Izmeni");
	private JButton btnDelete = new JButton("Obrisi");
	private JButton btnUndo = new JButton("Ponisti");
	private JButton btnRedo = new JButton("Ponovi");
	private JButton btnToFront = new JButton("Ispred");
	private JButton btnBringToFront = new JButton("Ispred svih");
	private JButton btnToBack = new JButton("Iza");
	private JButton btnBringToBack = new JButton("Iza svih");
	
	private JButton btnOpenFile = new JButton("Otvori fajl");
	private JButton btnSaveFile = new JButton("Sacuvaj fajl");
	private JButton btnReadCommand = new JButton("Ucitaj komandu");
	

	private final JPanel pnlLog = new JPanel();
	
	private final JPanel panel_2 = new JPanel();
	private final JLabel lblNewLabel = new JLabel("Dizajnerski obrasci Andjela Curcic IT35/2017");
	
	public AppView getView() {
		return view;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AppFrame frame = new AppFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public AppFrame() {
		setBackground(Color.GRAY);
		
		setTitle("IT35-2017 Andjela Curcic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1000,800);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(1000,600));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.setLayout(new BorderLayout(0,0));
		
		setContentPane(contentPane);
		
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		
		contentPane.add(view, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{153, 0};
		gbl_panel.rowHeights = new int[]{59, 43, 21, 39, 21, 39, 21, 42, 27, 40, 18, 39, 47, 49, 44, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		GridBagConstraints gbc_btnShapePoint = new GridBagConstraints();
		gbc_btnShapePoint.fill = GridBagConstraints.BOTH;
		gbc_btnShapePoint.insets = new Insets(0, 0, 5, 0);
		gbc_btnShapePoint.gridx = 0;
		gbc_btnShapePoint.gridy = 1;
		btnShapePoint.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(btnShapePoint, gbc_btnShapePoint);
		btnsShapes.add(btnShapePoint);
		
		GridBagConstraints gbc_btnShapeLine = new GridBagConstraints();
		gbc_btnShapeLine.fill = GridBagConstraints.BOTH;
		gbc_btnShapeLine.insets = new Insets(0, 0, 5, 0);
		gbc_btnShapeLine.gridx = 0;
		gbc_btnShapeLine.gridy = 3;
		btnShapeLine.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(btnShapeLine, gbc_btnShapeLine);
		btnsShapes.add(btnShapeLine);
		
		GridBagConstraints gbc_btnShapeCircle = new GridBagConstraints();
		gbc_btnShapeCircle.fill = GridBagConstraints.BOTH;
		gbc_btnShapeCircle.insets = new Insets(0, 0, 5, 0);
		gbc_btnShapeCircle.gridx = 0;
		gbc_btnShapeCircle.gridy = 5;
		btnShapeCircle.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(btnShapeCircle, gbc_btnShapeCircle);
		btnsShapes.add(btnShapeCircle);
	
		GridBagConstraints gbc_btnShapeRectangle = new GridBagConstraints();
		gbc_btnShapeRectangle.fill = GridBagConstraints.BOTH;
		gbc_btnShapeRectangle.insets = new Insets(0, 0, 5, 0);
		gbc_btnShapeRectangle.gridx = 0;
		gbc_btnShapeRectangle.gridy = 7;
		btnShapeRectangle.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(btnShapeRectangle, gbc_btnShapeRectangle);
		btnsShapes.add(btnShapeRectangle);
	
		GridBagConstraints gbc_btnShapeDonut = new GridBagConstraints();
		gbc_btnShapeDonut.fill = GridBagConstraints.BOTH;
		gbc_btnShapeDonut.insets = new Insets(0, 0, 5, 0);
		gbc_btnShapeDonut.gridx = 0;
		gbc_btnShapeDonut.gridy = 9;
		btnShapeDonut.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(btnShapeDonut, gbc_btnShapeDonut);
		btnsShapes.add(btnShapeDonut);
		
		GridBagConstraints gbc_btnShapeHexagon = new GridBagConstraints();
		gbc_btnShapeHexagon.insets = new Insets(0, 0, 5, 0);
		gbc_btnShapeHexagon.fill = GridBagConstraints.BOTH;
		gbc_btnShapeHexagon.gridx = 0;
		gbc_btnShapeHexagon.gridy = 11;
		btnShapeHexagon.setFont(new Font("Verdana", Font.BOLD, 12));
		panel.add(btnShapeHexagon, gbc_btnShapeHexagon);
		btnsShapes.add(btnShapeHexagon);
		
		GridBagConstraints gbc_btnColorEdge = new GridBagConstraints();
		gbc_btnColorEdge.fill = GridBagConstraints.BOTH;
		gbc_btnColorEdge.insets = new Insets(0, 0, 5, 0);
		gbc_btnColorEdge.gridx = 0;
		gbc_btnColorEdge.gridy = 13;
		btnColorEdge.setFont(new Font("Verdana", Font.BOLD, 12));
		btnColorEdge.addActionListener(edgeColorChooser());
		panel.add(btnColorEdge, gbc_btnColorEdge);
		
		
		GridBagConstraints gbc_btnColorInner = new GridBagConstraints();
		gbc_btnColorInner.fill = GridBagConstraints.BOTH;
		gbc_btnColorInner.gridx = 0;
		gbc_btnColorInner.gridy = 14;
		btnColorInner.setFont(new Font("Verdana", Font.BOLD, 12));
		btnColorInner.addActionListener(innerColorChooser());
		panel.add(btnColorInner, gbc_btnColorInner);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		contentPane.add(panel_1, BorderLayout.EAST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{44, 109, 0, 112, 31, 0};
		gbl_panel_1.rowHeights = new int[]{21, 27, 43, 20, 40, 19, 41, 18, 42, 0, 42, 52, 39, 0, 42, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
		GridBagConstraints gbc_btnOperationDrawing = new GridBagConstraints();
		btnOperationDrawing.setFont(new Font("Verdana", Font.BOLD, 12));
		
		btnOperationDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gbc_btnOperationDrawing.fill = GridBagConstraints.BOTH;
		gbc_btnOperationDrawing.insets = new Insets(0, 0, 5, 5);
		gbc_btnOperationDrawing.gridx = 1;
		gbc_btnOperationDrawing.gridy = 2;
		panel_1.add(btnOperationDrawing, gbc_btnOperationDrawing);
		btnsOperation.add(btnOperationDrawing);
		btnOperationDrawing.setSelected(true);
		
		
		GridBagConstraints gbc_btnOperationSelect = new GridBagConstraints();
		btnOperationSelect.setFont(new Font("Verdana", Font.BOLD, 12));
		btnOperationSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnsOperation.add(btnOperationSelect);
		gbc_btnOperationSelect.fill = GridBagConstraints.BOTH;
		gbc_btnOperationSelect.insets = new Insets(0, 0, 5, 5);
		gbc_btnOperationSelect.gridx = 3;
		gbc_btnOperationSelect.gridy = 2;
		panel_1.add(btnOperationSelect, gbc_btnOperationSelect);
		
		
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		btnEdit.setFont(new Font("Verdana", Font.BOLD, 12));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		gbc_btnEdit.fill = GridBagConstraints.BOTH;
		gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
		gbc_btnEdit.gridx = 1;
		gbc_btnEdit.gridy = 4;
		panel_1.add(btnEdit, gbc_btnEdit);
		
		
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		btnDelete.setFont(new Font("Verdana", Font.BOLD, 12));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		gbc_btnDelete.fill = GridBagConstraints.BOTH;
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 4;
		panel_1.add(btnDelete, gbc_btnDelete);
		
		
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		btnUndo.setFont(new Font("Verdana", Font.BOLD, 12));
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUndo.setVisible(false);
		gbc_btnUndo.fill = GridBagConstraints.BOTH;
		gbc_btnUndo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo.gridx = 1;
		gbc_btnUndo.gridy = 6;
		panel_1.add(btnUndo, gbc_btnUndo);
		
		
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		btnRedo.setFont(new Font("Verdana", Font.BOLD, 12));
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRedo.setVisible(false);
		gbc_btnRedo.fill = GridBagConstraints.BOTH;
		gbc_btnRedo.insets = new Insets(0, 0, 5, 5);
		gbc_btnRedo.gridx = 3;
		gbc_btnRedo.gridy = 6;
		panel_1.add(btnRedo, gbc_btnRedo);
		
		
		GridBagConstraints gbc_btnToFront = new GridBagConstraints();
		btnToFront.setFont(new Font("Verdana", Font.BOLD, 12));
		btnToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gbc_btnToFront.fill = GridBagConstraints.BOTH;
		gbc_btnToFront.insets = new Insets(0, 0, 5, 5);
		gbc_btnToFront.gridx = 1;
		gbc_btnToFront.gridy = 8;
		panel_1.add(btnToFront, gbc_btnToFront);
		
		
		GridBagConstraints gbc_btnBringToFront = new GridBagConstraints();
		btnBringToFront.setFont(new Font("Verdana", Font.BOLD, 12));
		btnBringToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gbc_btnBringToFront.fill = GridBagConstraints.BOTH;
		gbc_btnBringToFront.insets = new Insets(0, 0, 5, 5);
		gbc_btnBringToFront.gridx = 3;
		gbc_btnBringToFront.gridy = 8;
		panel_1.add(btnBringToFront, gbc_btnBringToFront);
		
		
		GridBagConstraints gbc_btnToBack = new GridBagConstraints();
		btnToBack.setFont(new Font("Verdana", Font.BOLD, 12));
		btnToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gbc_btnToBack.fill = GridBagConstraints.BOTH;
		gbc_btnToBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnToBack.gridx = 1;
		gbc_btnToBack.gridy = 10;
		panel_1.add(btnToBack, gbc_btnToBack);
		
		
		GridBagConstraints gbc_btnBringToBack = new GridBagConstraints();
		btnBringToBack.setFont(new Font("Verdana", Font.BOLD, 12));
		btnBringToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gbc_btnBringToBack.insets = new Insets(0, 0, 5, 5);
		gbc_btnBringToBack.fill = GridBagConstraints.BOTH;
		gbc_btnBringToBack.gridx = 3;
		gbc_btnBringToBack.gridy = 10;
		panel_1.add(btnBringToBack, gbc_btnBringToBack);
		
		
		GridBagConstraints gbc_btnSaveFile = new GridBagConstraints();
		btnSaveFile.setFont(new Font("Verdana", Font.BOLD, 12));
		btnSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		GridBagConstraints gbc_btnOpenFile = new GridBagConstraints();
		btnOpenFile.setFont(new Font("Verdana", Font.BOLD, 12));
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		gbc_btnOpenFile.fill = GridBagConstraints.BOTH;
		gbc_btnOpenFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpenFile.gridx = 1;
		gbc_btnOpenFile.gridy = 12;
		panel_1.add(btnOpenFile, gbc_btnOpenFile);
		gbc_btnSaveFile.fill = GridBagConstraints.BOTH;
		gbc_btnSaveFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveFile.gridx = 3;
		gbc_btnSaveFile.gridy = 12;
		panel_1.add(btnSaveFile, gbc_btnSaveFile);
		
		
		GridBagConstraints gbc_btnReadCommand = new GridBagConstraints();
		gbc_btnReadCommand.gridwidth = 3;
		btnReadCommand.setFont(new Font("Verdana", Font.BOLD, 12));
		btnReadCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		gbc_btnReadCommand.fill = GridBagConstraints.BOTH;
		gbc_btnReadCommand.insets = new Insets(0, 0, 0, 5);
		gbc_btnReadCommand.gridx = 1;
		gbc_btnReadCommand.gridy = 14;
		panel_1.add(btnReadCommand, gbc_btnReadCommand);
		btnReadCommand.setVisible(false);
		
		
		
		
		contentPane.add(pnlLog, BorderLayout.SOUTH);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
		scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
			
			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				e.getAdjustable().setValue(e.getAdjustable().getMaximum());
			}
		});
		
		pnlLog.add(scrollPane);
		
		contentPane.add(panel_2, BorderLayout.NORTH);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		
		panel_2.add(lblNewLabel);
		
		
	}
	
	private ActionListener edgeColorChooser() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color edgeColor = JColorChooser.showDialog(null, "izaberite boju ivice",Color.BLACK);
				if (edgeColor != null) {
					
					btnColorEdge.setBackground(edgeColor);
				}
			}
		};
	}
	
	private ActionListener innerColorChooser() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color innerColor = JColorChooser.showDialog(null, "izaberite boju unustrasnjosti",Color.BLACK);
				if (innerColor != null) {
					
					btnColorInner.setBackground(innerColor);
				}
			}
		};
	}
	

	public ButtonGroup getBtnsOperation() {
		return btnsOperation;
	}

	public ButtonGroup getBtnsShapes() {
		return btnsShapes;
	}

	public JToggleButton getBtnShapePoint() {
		return btnShapePoint;
	}

	public JToggleButton getBtnShapeLine() {
		return btnShapeLine;
	}

	public JToggleButton getBtnShapeCircle() {
		return btnShapeCircle;
	}

	public JToggleButton getBtnShapeRectangle() {
		return btnShapeRectangle;
	}

	public JToggleButton getBtnShapeDonut() {
		return btnShapeDonut;
	}

	public JToggleButton getBtnShapeHexagon() {
		return btnShapeHexagon;
	}

	public JButton getBtnColorEdge() {
		return btnColorEdge;
	}

	public JButton getBtnColorInner() {
		return btnColorInner;
	}

	public JToggleButton getBtnOperationDrawing() {
		return btnOperationDrawing;
	}

	public JToggleButton getBtnOperationSelect() {
		return btnOperationSelect;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnUndo() {
		return btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public JButton getBtnToFront() {
		return btnToFront;
	}

	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public JButton getBtnToBack() {
		return btnToBack;
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	

	

	public JButton getBtnReadCommand() {
		return btnReadCommand;
	}
	
	

	
	

}

