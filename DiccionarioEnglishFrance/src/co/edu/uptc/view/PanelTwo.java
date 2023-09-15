package co.edu.uptc.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTwo extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblNWEnglish;
	private JTextField numberWEnglish;
	private JLabel lblNWFrance;
	private JTextField numberWFrance;
	
	public PanelTwo(ActionListener listener) {
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
		setBackground(Color.LIGHT_GRAY);
		initComponents(listener);
	}
	
	public void initComponents(ActionListener listener) {
		lblNWEnglish = new JLabel("Total Inglés");
		add(lblNWEnglish);
		numberWEnglish = new JTextField(5);
		numberWEnglish.setEnabled(false);
		add(numberWEnglish);
		lblNWFrance = new JLabel("Total Francés");
		add(lblNWFrance);
		numberWFrance = new JTextField(5);
		numberWFrance.setEnabled(false);
		add(numberWFrance);
	}

	public JTextField getNumberWEnglish() {
		return numberWEnglish;
	}

	public void setNumberWEnglish(JTextField numberWEnglish) {
		this.numberWEnglish = numberWEnglish;
	}

	public JTextField getNumberWFrance() {
		return numberWFrance;
	}

	public void setNumberWFrance(JTextField numberWFrance) {
		this.numberWFrance = numberWFrance;
	}
	
}
