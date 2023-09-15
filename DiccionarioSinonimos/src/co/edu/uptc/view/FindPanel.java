package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel word;
	private JTextField txtWord;
	private JButton btnFind;
	
	public FindPanel(ActionListener listener) {
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		initComponents(listener);
		addComponents();
	}
	
	public void initComponents(ActionListener listener) {
		word = new JLabel("Word: ");
		txtWord = new JTextField(30);
		btnFind = new JButton("Find Synonym");
		btnFind.setActionCommand("find");
		btnFind.addActionListener(listener);
	}
	
	public void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		add(word, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		add(txtWord, gbc);
		
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		add(btnFind, gbc);
	
	}

	public JTextField getTxtWord() {
		return txtWord;
	}

	public void setTxtWord(JTextField txtWord) {
		this.txtWord = txtWord;
	}
	
}
