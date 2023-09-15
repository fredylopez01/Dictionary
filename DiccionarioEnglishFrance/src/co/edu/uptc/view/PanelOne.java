package co.edu.uptc.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelOne extends JPanel{
	private static final long serialVersionUID = 1L;
	private JLabel word;
	private JTextField txtWord;
	private JButton btnTEnglish;
	private JTextField txtWEnglish;
	private JButton btnTFreance;
	private JTextField txtWFrance;
	
	public PanelOne(ActionListener listener) {
		GridLayout gl = new GridLayout(3,2);
		setLayout(gl);
		initComponents(listener);
	}
	
	public void initComponents(ActionListener listener) {
		word = new JLabel("Palabra: ");
		add(word);
		txtWord = new JTextField(10);
		add(txtWord);
		btnTEnglish = new JButton("Traduccir a Inglés");
		btnTEnglish.setActionCommand("tEnglish");
		btnTEnglish.addActionListener(listener);
		add(btnTEnglish);
		txtWEnglish = new JTextField(10);
		add(txtWEnglish);
		btnTFreance = new JButton("Traduccir a Francés");
		btnTFreance.setActionCommand("tFrance");
		btnTFreance.addActionListener(listener);
		add(btnTFreance);
		txtWFrance = new JTextField(10);
		add(txtWFrance);
	}
	

	public JTextField getTxtWord() {
		return txtWord;
	}

	public void setTxtWord(JTextField txtWord) {
		this.txtWord = txtWord;
	}

	public JTextField getTxtWEnglish() {
		return txtWEnglish;
	}

	public void setTxtWEnglish(JTextField txtWEnglish) {
		this.txtWEnglish = txtWEnglish;
	}

	public JTextField getTxtWFrance() {
		return txtWFrance;
	}

	public void setTxtWFrance(JTextField txtWFrance) {
		this.txtWFrance = txtWFrance;
	}
	
}
