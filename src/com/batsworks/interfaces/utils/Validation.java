package com.batsworks.interfaces.utils;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

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

	public static void onlyNumbers(JTextField textField) {
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (!Character.isDigit(e.getKeyChar())) {
					e.consume();
				}
			}
		});
	}

	public static void onlyLetters(JTextField textField) {
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (Character.isDigit(e.getKeyChar()) || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					e.consume();
				}
			}
		});
	}

	public static void regexInput(JTextField field, String regex, JLabel label, String errorMessage) {
		AbstractDocument document = (AbstractDocument) field.getDocument();
		Pattern patt = Pattern.compile(regex);
		document.setDocumentFilter(new DocumentFilter() {
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
				String newText = text.substring(0, offset) + text + text.substring(offset + offset);
				if (newText.isEmpty() || patt.matcher(newText).matches()) {
					super.insertString(fb, offset, text, attrs);
				}
				System.out.println(newText);
			}
			
		});
	}
}
