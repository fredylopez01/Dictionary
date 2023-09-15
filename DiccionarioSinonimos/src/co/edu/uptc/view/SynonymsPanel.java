package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class SynonymsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private TitledBorder title;
	private JButton btnBack;
	private JTextField txtSynonym;
	private JButton btnNext;
	private JLabel numberSynonym;
	
	public SynonymsPanel(ActionListener listener) {
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		initComponents(listener);
		addComponents();
	}
	
	public void initComponents(ActionListener listener) {
		title = BorderFactory.createTitledBorder(null, "Synonyms", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 12), Color.BLUE);
		title.setTitleJustification(TitledBorder.LEFT);
		title.setTitlePosition(TitledBorder.TOP);
		setBorder(title);
		
		btnBack = new JButton("<<");
		btnBack.setActionCommand("back");
		btnBack.addActionListener(listener);
		
		txtSynonym = new JTextField(30);
		txtSynonym.setEditable(false);
		
		btnNext = new JButton(">>");
		btnNext.setActionCommand("next");
		btnNext.addActionListener(listener);
		
		numberSynonym = new JLabel("Synonyms number: ");
		numberSynonym.setFont(new Font("Arial", Font.BOLD, 12));
		numberSynonym.setHorizontalAlignment(JLabel.CENTER);
	}
	
	public void addComponents() {
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		add(btnBack, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		add(txtSynonym, gbc);
		
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		add(btnNext, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		add(numberSynonym, gbc);
	}

	public JTextField getTxtSynonym() {
		return txtSynonym;
	}

	public void setTxtSynonym(JTextField txtSynonym) {
		this.txtSynonym = txtSynonym;
	}

	public JLabel getNumberSynonym() {
		return numberSynonym;
	}

	public void setNumberSynonym(JLabel numberSynonym) {
		this.numberSynonym = numberSynonym;
	}
	
}
