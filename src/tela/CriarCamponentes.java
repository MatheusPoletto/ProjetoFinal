package tela;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CriarCamponentes {

	public JPanel criarPanel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JPanel panel,
			Boolean visibilidade) {
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createTitledBorder(texto));
		panel.setBounds(col, lin, lar, alt);
		panel.setVisible(visibilidade);
		return panel;

	}
	
	public JLabel criarLabel(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label) {
		label = new JLabel(texto);
		label.setBounds(col, lin, lar, alt);
		label.setVisible(true);
		return label;

	}

	public JTextField criarTextField(Integer col, Integer lin, Integer lar, Integer alt, JTextField textField) {
		textField = new JTextField();
		textField.setBounds(col, lin, lar, alt);
		textField.setVisible(true);
		return textField;

	}

	public JButton criarBotao(String texto, Integer col, Integer lin, Integer lar, Integer alt, JButton button) {
		button = new JButton(texto);
		button.setBounds(col, lin, lar, alt);
		button.setVisible(true);
		return button;

	}
	
	public JRadioButton criarRadioButton(String texto, Integer col, Integer lin, Integer lar, Integer alt, JRadioButton radioButton){
		radioButton = new JRadioButton(texto);
		radioButton.setBounds(col, lin, lar, alt);
		radioButton.setVisible(true);
		return radioButton;
	}
}
