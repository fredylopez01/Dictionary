package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SynonymAggregationDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel chooseWord;
	private JLabel addSynonym;
	private JComboBox<String> synonyms;
	private JTextField txtSynonym;
	private JButton btnAdd;
	
	public SynonymAggregationDialog(JFrame father, ActionListener listener, boolean modal, String[] words) {
		super(father, modal);
		setTitle("Add Synonym");
		setSize(350, 150);
		initComponents(listener, words);
		addComponents();
	}
	
	public void initComponents(ActionListener listener, String[] words) {
		chooseWord = new JLabel("Choose the word: ");
		synonyms = new JComboBox<String>(words);
		addSynonym = new JLabel("New Synonym: ");
		txtSynonym = new JTextField(15);
		btnAdd = new JButton("Add New Synonym");
		btnAdd.setActionCommand("addSynonymDefinitive");
		btnAdd.addActionListener(listener);
	}
	
	public void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridy = 0;
		add(chooseWord, gbc);
		
		gbc.gridy = 1;
		add(synonyms, gbc);
		
		gbc.gridy = 2;
		add(addSynonym, gbc);
		
		gbc.gridy = 3;
		add(txtSynonym, gbc);
		
		gbc.gridy = 4;
		add(btnAdd, gbc);
	}

	public JComboBox<String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(JComboBox<String> synonyms) {
		this.synonyms = synonyms;
	}

	public JTextField getTxtSynonym() {
		return txtSynonym;
	}

	public void setTxtSynonym(JTextField txtSynonym) {
		this.txtSynonym = txtSynonym;
	}
	
}
