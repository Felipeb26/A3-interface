package main.com.batsworks.interfaces.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import main.com.batsworks.interfaces.model.enums.TipoEntrada;

public class CustomRegex implements DocumentListener {

	TipoEntrada entrada;
	Long limite;
	JTextField field;
	String regex;

	public CustomRegex(TipoEntrada tipoEntrada, Long limite, JTextField field, String regex) {
		this.entrada = tipoEntrada;
		this.limite = limite;
		this.field = field;
		this.regex = regex;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		validade();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		validade();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		validade();
	}

	private void validade() {
			switch (entrada) {
			case DECIMAL -> formatDecimal();
			case EMAIL -> formatEmail();
			case NOME -> formatNome();
			case NUMERO -> formatNumero();
			default -> formatNome();
			}
	}

	private void formatEmail() {
	}

	private void formatNumero() {
		String text = field.getText();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		if (text.length() >= limite)
			return;
		if (matcher.matches())
			field.setText(text.replaceAll(regex, ""));
	}

	private void formatNome() {
	}

	private void formatDecimal() {
	}
}
