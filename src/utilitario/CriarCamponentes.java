package utilitario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CriarCamponentes {

	public JLabel criarLabelTitulo(String texto, Integer col, Integer lin, Integer lar, Integer alt, JLabel label) {
		label = new JLabel(texto, SwingConstants.CENTER);
		label.setBounds(col, lin, lar, alt);
		label.setVisible(true);
		label.setFont(new Font("ARIAL", Font.PLAIN, 18));
		label.setOpaque(true);
		label.setBackground(new Color(23, 20, 20));
		label.setForeground(Color.white);
		label.setBackground(new Color(23, 20, 20));
		label.setForeground(Color.white);
		return label;
	}

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

	public JLabel criarLabelCentralizada(String texto, Integer col, Integer lin, Integer lar, Integer alt,
			JLabel label) {
		label = new JLabel(texto, SwingConstants.CENTER);
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

	public JRadioButton criarRadioButton(String texto, Integer col, Integer lin, Integer lar, Integer alt,
			JRadioButton radioButton) {
		radioButton = new JRadioButton(texto);
		radioButton.setBounds(col, lin, lar, alt);
		radioButton.setVisible(true);
		return radioButton;
	}

	public BufferedImage redimensionarImagem(String endereco, Integer larg, Integer altu) {
		File arquivo = new File(endereco);
		BufferedImage aux = null;
		try {
			BufferedImage bi;
			bi = ImageIO.read(arquivo);
			aux = new BufferedImage(larg, altu, bi.getType());
			Graphics2D g = aux.createGraphics();
			AffineTransform at = AffineTransform.getScaleInstance((double) larg / bi.getWidth(),
					(double) altu / bi.getHeight());
			g.drawRenderedImage(bi, at);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return aux;
	}

	public JButton alterarCorBotoes(JButton button) {
		button.setBackground(new Color(23, 20, 20));
		button.setForeground(Color.white);
		return button;
	}

}
