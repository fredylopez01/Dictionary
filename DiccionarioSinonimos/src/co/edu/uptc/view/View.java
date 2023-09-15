package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private ActionListener listener;
	private FindPanel panelOne;
	private SynonymsPanel panelTwo;
	private AggregationPanel panelThree;
	private WordAggregationDialog addWordTest;
	private SynonymAggregationDialog addSynonym;
	
	public View(ActionListener listener) {
		super("Synonyms Dictionary");
		setSize(500, 180);
		this.listener = listener; 
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void initComponents() {
		panelOne = new FindPanel(listener);
		add(panelOne, BorderLayout.NORTH);
		panelTwo = new SynonymsPanel(listener);
		add(panelTwo, BorderLayout.CENTER);
		panelThree = new AggregationPanel(listener);
		add(panelThree, BorderLayout.SOUTH);
	}
	
	public String txtWord() {
		return panelOne.getTxtWord().getText();
	}
	
	public void updateSynonyms(int number, String synonym) {
		panelTwo.getNumberSynonym().setText("Synonyms number: " + number);
		panelTwo.getTxtSynonym().setText(synonym);
	}
	
	public void openAddWord() {
		addWordTest = new WordAggregationDialog(this, listener, true);
		addWordTest.setLocationRelativeTo(null);
		addWordTest.setVisible(true);
	}
	
	public void closeAddWord() {
		addWordTest.dispose();
	}
	
	public String newWord() {
		return addWordTest.getWord().getText();
	}
	
	public void openAddSynonym(String[] words) {
		addSynonym = new SynonymAggregationDialog(this, listener, true, words);
		addSynonym.setLocationRelativeTo(null);
		addSynonym.setVisible(true);
	}
	
	public void closeAddSynonym() {
		addSynonym.dispose();
	}
	
	public String wordNewSynonym() {
		return addSynonym.getSynonyms().getSelectedItem().toString();
	}
	
	public String newSynonym() {
		return addSynonym.getTxtSynonym().getText();
	}
}
