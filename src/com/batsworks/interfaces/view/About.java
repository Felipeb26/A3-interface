package com.batsworks.interfaces.view;

import com.batsworks.interfaces.config.styles.FontStyle;
import com.batsworks.interfaces.utils.Change;

import java.awt.Color;

import javax.swing.*;

public class About extends JFrame {

	JLabel aboutLabel;
	JTextArea aboutTextArea;
	JButton btnSair;

	public About() {
		setBounds(100, 100, 701, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		Change.controllCloseFrame(this, false);
		getContentPane().setLayout(null);

		aboutTextArea = new JTextArea(
				"o contr\u00E1rio do que se acredita, Lorem Ipsum\n n\u00E3o \u00E9 simplesmente um texto rand\u00F4mico."
						+ " \nCom mais de 2000 anos, suas ra\u00EDzes podem ser encontradas em uma obra de literatura latina cl\u00E1ssica datada de 45 AC.\n"
						+ " Richard McClintock, um professor de latim do Hampden-Sydney College na Virginia, pesquisou uma das mais obscuras palavras em latim,\n"
						+ " consectetur, oriunda de uma passagem de Lorem Ipsum, e, procurando por entre cita\u00E7\u00F5es da palavra na literatura\n"
						+ " cl\u00E1ssica, descobriu a sua indubit\u00E1vel origem. Lorem Ipsum vem das se\u00E7\u00F5es 1.10.32 e 1.10.33\n"
						+ " do \"de Finibus Bonorum et Malorum\" (Os Extremos do Bem e do Mal), de C\u00EDcero, escrito em 45 AC.\n"
						+ " Este livro \u00E9 um tratado de teoria da \u00E9tica muito popular na \u00E9poca da Renascen\u00E7a.\n"
						+ " A primeira linha de Lorem Ipsum, \"Lorem Ipsum dolor sit amet...\" vem de uma linha na se\u00E7\u00E3o 1.10.32.");
		aboutTextArea.setBounds(172, 71, 492, 336);
		aboutTextArea.setLineWrap(true);
		aboutTextArea.setBackground(getBackground());
		aboutTextArea.setEditable(false);
		aboutTextArea.setWrapStyleWord(true);
		getContentPane().add(aboutTextArea);

		aboutLabel = new JLabel("ABOUT");
		aboutLabel.setFont(new FontStyle());
		aboutLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		aboutLabel.setBounds(65, 40, 76, 29);
		getContentPane().add(aboutLabel);

		btnSair = new JButton("SAIR");
		btnSair.setBounds(26, 455, 81, 29);
		getContentPane().add(btnSair);

		Change.toFrame(btnSair, this, Index.class);
		
	}

}
