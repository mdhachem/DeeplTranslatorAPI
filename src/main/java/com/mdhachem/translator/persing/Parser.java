package com.mdhachem.translator.persing;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public final class Parser {

	private final Gson gson;

	public Parser() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gson = gsonBuilder.create();
	}

	public List<TextResponse> parseTextResult(String json) {
		Result result = gson.fromJson(json, Result.class);
		return result.getTextResponses();
	}

	public String parseErrorMessage(String json) {
		ErrorResponse response = gson.fromJson(json, ErrorResponse.class);

		if (response != null) {
			return response.toString();
		} else {
			return "";
		}
	}
}
