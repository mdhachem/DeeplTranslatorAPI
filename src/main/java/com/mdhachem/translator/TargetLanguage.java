package com.mdhachem.translator;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public enum TargetLanguage {

	ENGLISH("en"), ENGLISH_AMERICAN("en-US"), ENGLISH_BRITISH("en-GB"), BULGARIAN("bg"), CHINESE("zh"), CZECH("cs"),
	DANISH("da"), DUTCH("nl"), ESTONIAN("et"), FINNISH("fi"), FRENCH("fr"), GERMAN("de"), GREEK("el"), HUNGARIAN("hu"),
	JAPANESE("ja"), LATVIAN("lv"), LITHUANIAN("lt"), POLISH("pl"), PORTUGUESE("pt"), PORTUGUESE_BRAZILIAN("pt-BR"),
	PORTUGUESE_ALL_VARIETIES("pt-pt"), ROMANIAN("ro"), RUSSIAN("ru"), SLOVAK("sk"), SLOVENIAN("sl"), SPANISH("es"),
	SWEDISH("sv");

	private final String languageCode;

	private TargetLanguage(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageCode() {
		return languageCode;
	}

}
