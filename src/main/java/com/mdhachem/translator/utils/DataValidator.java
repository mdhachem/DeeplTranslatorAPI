package com.mdhachem.translator.utils;

import java.util.List;

import com.mdhachem.translator.TargetLanguage;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class DataValidator {

	private DataValidator() {

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
