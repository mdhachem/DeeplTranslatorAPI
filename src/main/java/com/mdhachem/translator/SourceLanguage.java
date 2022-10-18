package com.mdhachem.translator;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public enum SourceLanguage {

	BULGARIAN("bg"), CHINESE("zh"), CZECH("cs"), DANISH("da"), DUTCH("nl"), ENGLISH("en"), ESTONIAN("et"),
	FINNISH("fi"), FRENCH("fr"), GERMAN("de"), GREEK("el"), HUNGARIAN("hu"), JAPANESE("ja"), LATVIAN("lv"),
	LITHUANIAN("lt"), POLISH("pl"), PORTUGUESE("pt"), ROMANIAN("ro"), RUSSIAN("ru"), SLOVAK("sk"), SLOVENIAN("sl"),
	SPANISH("es"), SWEDISH("sv");

	private final String languageCode;

	private SourceLanguage(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageCode() {
		return languageCode;
	}
}
