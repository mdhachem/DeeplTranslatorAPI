package com.mdhachem.translator.persing;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class TextResponse {

	private final String text;
	private final String detectedSourceLanguage;

	public TextResponse(String text, String detectedSourceLanguage) {
		this.text = text;
		this.detectedSourceLanguage = detectedSourceLanguage;
	}

	public String getText() {
		return text;
	}

	public String getDetectedSourceLanguage() {
		return detectedSourceLanguage;
	}
}
