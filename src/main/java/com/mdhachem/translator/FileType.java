package com.mdhachem.translator;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public enum FileType {

	XML("xml"), WORD("docs"), PDF("pdf"), EXCEL("xlsx"), POWERPOINT("pptx"), HTML("html"), JSON("json");

	private final String type;

	private FileType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
