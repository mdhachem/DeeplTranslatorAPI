package com.mdhachem.translator.utils;

import java.util.List;

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
		return response != null && !response.isEmpty() ? response.get(0).getText() : EMPTY_STRING;
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
