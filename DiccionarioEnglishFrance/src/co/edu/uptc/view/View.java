package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class View extends JFrame {
	private static final long serialVersionUID = 1L;
	private ActionListener listener;
	private PanelOne panelOne;
	private PanelTwo panelTwo;
	private PaneelThree panelThree;
	
	public View(ActionListener listener) {
		super("Synonyms Dictionary");
		setSize(350, 300);
		this.listener = listener; 
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void initComponents() {
		panelOne = new PanelOne(listener);
		add(panelOne, BorderLayout.NORTH);
		panelTwo = new PanelTwo(listener);
		add(panelTwo, BorderLayout.CENTER);
		panelThree = new PaneelThree(listener);
		add(panelThree, BorderLayout.SOUTH);
	}
	
	public String txtWord() {
		return panelOne.getTxtWord().getText();
	}
	
	public void updateTEnGlish(String tEnglish) {
		panelOne.getTxtWEnglish().setText(tEnglish);
	}
	
	public void updateTFrance(String tFrance) {
		panelOne.getTxtWFrance().setText(tFrance);
	}
	
	public String txtNewWord() {
		return panelThree.getTxtNewWord().getText();
	}
	
	public String txtNewTraduction() {
		return panelThree.getTxtNewTraduction().getText();
	}
	
	public void updateAddNewWord() {
		panelThree.getTxtNewWord().setText("");
		panelThree.getTxtNewTraduction().setText("");
	}
	
	public void updateNumberEnglish(int numEnglish) {
		panelTwo.getNumberWEnglish().setText(String.valueOf(numEnglish));
	}
	
	public void updateNumberFrench( int numFrance) {
		panelTwo.getNumberWFrance().setText(String.valueOf(numFrance));
	}
}
