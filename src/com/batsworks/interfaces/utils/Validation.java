package com.batsworks.interfaces.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;

public final class Validation {

	Validation() {
		throw new IllegalStateException("Utility class");
	}

	public static void notNull(JTextField... textFields) {
		for (var textField : textFields) {
			var text = textField.getText();
			if (text == null || text.isBlank() || text.isEmpty())
				throw new IllegalStateException("Campo não pode ser nulo");
		}
	}

	public static void regexInput(JTextField field, String regex, JLabel label, String errorMessage) {
		AbstractDocument document = (AbstractDocument) field.getDocument();
		Pattern patt = Pattern.compile(regex);
		document.addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				validateText();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				validateText();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				validateText();
			}

			private void validateText() {
				SwingUtilities.invokeLater(() -> {
					String text = field.getText();
					Matcher matcher = patt.matcher(text);
					if (!matcher.matches()) {
						label.setText("");
						field.setText(text.replaceAll(regex, ""));
					} else {
						label.setText(errorMessage);
					}
				});
			}
		});
	}
}
