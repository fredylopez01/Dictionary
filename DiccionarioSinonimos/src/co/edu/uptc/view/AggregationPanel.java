package co.edu.uptc.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AggregationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btnAddWord;
	private JButton btnAddSynonym;
	
	public AggregationPanel(ActionListener listener) {
		setLayout(new FlowLayout());
		
		initComponents(listener);
	}
	
	public void initComponents(ActionListener listener) {
		btnAddWord = new JButton("Add Word");
		btnAddWord.setActionCommand("addWord");
		btnAddWord.addActionListener(listener);
		add(btnAddWord);
		
		btnAddSynonym = new JButton("Add Synonym");
		btnAddSynonym.setActionCommand("addSynonym");
		btnAddSynonym.addActionListener(listener);
		add(btnAddSynonym);
	}

	public JButton getBtnAddWord() {
		return btnAddWord;
	}

	public void setBtnAddWord(JButton btnAddWord) {
		this.btnAddWord = btnAddWord;
	}

	public JButton getBtnAddSynonym() {
		return btnAddSynonym;
	}

	public void setBtnAddSynonym(JButton btnAddSynonym) {
		this.btnAddSynonym = btnAddSynonym;
	}
	
}
