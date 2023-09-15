package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WordAggregationDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel addWord;
	private JTextField word;
	private JButton btnAdd;
	
	public WordAggregationDialog(JFrame father, ActionListener listener, boolean modal) {
		super(father, modal);
		setTitle("Add Word");
		setSize(350, 150);
		initComponents(listener);
		addComponents();
	}
	
	public void initComponents(ActionListener listener) {
		addWord = new JLabel("New word: ");
		word = new JTextField(20);
		btnAdd = new JButton("Add New Word");
		btnAdd.setActionCommand("addWordDefinitive");
		btnAdd.addActionListener(listener);
	}
	
	public void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		add(addWord, gbc);
		
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		add(word, gbc);
		
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		add(btnAdd, gbc);
	}

	public JTextField getWord() {
		return word;
	}

	public void setWord(JTextField word) {
		this.word = word;
	}
	
}
