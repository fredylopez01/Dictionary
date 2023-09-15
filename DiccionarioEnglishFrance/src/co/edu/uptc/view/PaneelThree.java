package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PaneelThree extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblWord;
	private JTextField txtNewWord;
	private JLabel lblTraduction;
	private JTextField txtNewTraduction;
	private JButton btnAddTEnglish;
	private JButton btnAddTFrance;
	
	public PaneelThree(ActionListener listener) {
		setLayout(new GridBagLayout());
		initComponents(listener);
		addComponents();
		setBorder(new EmptyBorder(25, 30, 25, 30));
	}
	
	public void initComponents(ActionListener listener) {
		lblWord = new JLabel("Palabra:");
		txtNewWord = new JTextField(7);
		
		lblTraduction = new JLabel("Traducción:");
		txtNewTraduction = new JTextField(6);
		
		btnAddTEnglish = new JButton("Agregar a Inglés");
		btnAddTEnglish.setActionCommand("addTEnglish");
		btnAddTEnglish.addActionListener(listener);
		
		btnAddTFrance = new JButton("Agregar a Francés");
		btnAddTFrance.setActionCommand("addTFrance");
		btnAddTFrance.addActionListener(listener);
	}
	
	public void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lblWord, gbc);
		
		gbc.gridx = 1;
		add(txtNewWord, gbc);
		
		gbc.gridx = 2;
		add(lblTraduction, gbc);
		
		gbc.gridx = 3;
		add(txtNewTraduction, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		add(btnAddTEnglish, gbc);
		
		gbc.gridx = 2;
		add(btnAddTFrance, gbc);
	}
	
	

	public JTextField getTxtNewWord() {
		return txtNewWord;
	}

	public void setTxtNewWord(JTextField txtNewWord) {
		this.txtNewWord = txtNewWord;
	}

	public JTextField getTxtNewTraduction() {
		return txtNewTraduction;
	}

	public void setTxtNewTraduction(JTextField txtNewTraduction) {
		this.txtNewTraduction = txtNewTraduction;
	}
	
}
