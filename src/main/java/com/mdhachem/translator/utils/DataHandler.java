package com.mdhachem.translator.utils;

import java.util.List;
import java.util.Optional;

import com.mdhachem.translator.TargetLanguage;
import com.mdhachem.translator.persing.TextResponse;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class DataHandler {

	public static final String EMPTY_STRING = "";

	private DataHandler() {

	}

	public static String getResultAsString(List<TextResponse> response) {
		if (response != null && !response.isEmpty()) {
			Optional<TextResponse> element = response.stream().findFirst();
			if (element.isPresent()) {
				return element.get().getText();
			}
		}
		return EMPTY_STRING;
	}

	public static void checkTargetLanguage(TargetLanguage targetLanguage) {
		if (targetLanguage == null) {
			throw new IllegalArgumentException("Source Language must be Not NULL!");
		}
	}

	public static void checkListInput(List<String> listOfString) {
		if (listOfString == null) {
			throw new IllegalArgumentException("The List of String must be Not NULL!");
		}

	}

}
