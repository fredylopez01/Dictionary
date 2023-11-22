package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

public class JDChooseTypeFile extends JDialog {
	private static final long serialVersionUID = 1L;
	private JLabel lblQuestion;
	private ButtonGroup options;
	private JRadioButtonMenuItem optiontxt;
	private JRadioButtonMenuItem optionxml;
	private JRadioButtonMenuItem optionjson;
	private JButton btnIsOk;
	
	public JDChooseTypeFile(JFrame father, ActionListener listener) {
		super(father, true);
		setTitle("Elejir documento");
		setLocationRelativeTo(father);
		setSize(350, 150);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		Font mf = new Font("Sans Serif", Font.PLAIN, 13);
		setLayout(new GridLayout(5, 1));
		lblQuestion = new JLabel("¿Con cuál documento desea trabajar?");
		lblQuestion.setFont(mf);
		add(lblQuestion);
		
		optiontxt = new JRadioButtonMenuItem(".txt");
		optiontxt.setFont(mf);
		add(optiontxt);
		
		optionxml = new JRadioButtonMenuItem(".xml");
		optionxml.setFont(mf);
		add(optionxml);
		
		optionjson = new JRadioButtonMenuItem(".json", true);
		optionjson.setFont(mf);
		add(optionjson);
		
		options = new ButtonGroup();
		options.add(optiontxt);
		options.add(optionxml);
		options.add(optionjson);
		
		
		btnIsOk = new JButton("Aplicar");
		btnIsOk.setFont(mf);
		btnIsOk.setBackground(new Color(94, 255, 94));
		btnIsOk.setActionCommand("chooseFile");
		btnIsOk.addActionListener(listener);
		add(btnIsOk);
	}

	public JRadioButtonMenuItem getOptiontxt() {
		return optiontxt;
	}

	public void setOptiontxt(JRadioButtonMenuItem optiontxt) {
		this.optiontxt = optiontxt;
	}

	public JRadioButtonMenuItem getOptionxml() {
		return optionxml;
	}

	public void setOptionxml(JRadioButtonMenuItem optionxml) {
		this.optionxml = optionxml;
	}

	public JRadioButtonMenuItem getOptionjson() {
		return optionjson;
	}

	public void setOptionjson(JRadioButtonMenuItem optionjson) {
		this.optionjson = optionjson;
	}
	
}
