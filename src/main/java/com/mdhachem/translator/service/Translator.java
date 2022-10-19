package com.mdhachem.translator.service;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.mdhachem.exception.TranslatorException;
import com.mdhachem.translator.FileType;
import com.mdhachem.translator.SourceLanguage;
import com.mdhachem.translator.TargetLanguage;
import com.mdhachem.translator.TranslationOptions;
import com.mdhachem.translator.http.HttpClient;
import com.mdhachem.translator.http.HttpResponse;
import com.mdhachem.translator.persing.Parser;
import com.mdhachem.translator.persing.TextResponse;
import com.mdhachem.translator.utils.DataHandler;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class Translator {

	private static final Parser jsonParser = new Parser();

	private final String authKey;
	private final int connectTimeout;
	private final int readTimeout;
	private final int repetitions;
	private final TranslationOptions translationOptions;

	private Translator(String authKey, int connectTimeout, int readTimeout, int repetitions,
			TranslationOptions translationOptions) {
		this.authKey = authKey;
		this.connectTimeout = connectTimeout;
		this.readTimeout = readTimeout;
		this.repetitions = repetitions;
		this.translationOptions = translationOptions;
	}

	public String getAuthKey() {
		return authKey;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public TranslationOptions getTranslationOptions() {
		return translationOptions;
	}

	/***
	 * Translate method take as parameter the String text and return String text
	 * translated
	 * 
	 * @param text
	 * @param from
	 * @param to
	 * @return String
	 */
	public String translate(String text, SourceLanguage from, TargetLanguage to) {
		DataHandler.checkTargetLanguage(to);
		HttpResponse httpResponse = HttpClient.translate(this, text, from, to);
		if (httpResponse.getStatus() == 200) {
			List<TextResponse> response = jsonParser.parseTextResult(httpResponse.getResponseContent());
			return DataHandler.getResultAsString(response);
		}
		throw new TranslatorException(jsonParser.parseErrorMessage(httpResponse.getResponseContent()));
	}

	/***
	 * Translate method take as parameter the String text and return String text
	 * translated
	 * 
	 * @param text
	 * @param from
	 * @param to
	 * @return String
	 */
	public List<String> translate(List<String> texts, SourceLanguage from, TargetLanguage to) {
		DataHandler.checkTargetLanguage(to);
		DataHandler.checkListInput(texts);
		List<String> result = new ArrayList<>();
		texts.forEach(text -> {
			HttpResponse httpResponse = HttpClient.translate(this, text, from, to);
			if (httpResponse.getStatus() == 200) {
				List<TextResponse> response = jsonParser.parseTextResult(httpResponse.getResponseContent());
				result.add(DataHandler.getResultAsString(response));
			} else {
				result.add(DataHandler.EMPTY_STRING);
			}
		});

		return result;
	}

	/***
	 * Translate method take as parameter the Path and return void
	 * 
	 * @param path
	 * @param type
	 * @param from
	 * @param to
	 */
	public void translateDocument(Path path, FileType type, SourceLanguage from, TargetLanguage to) {
		throw new UnsupportedOperationException("The method are not ready yet.");
	}

	/***
	 * Translate method take as parameter the InputStream and return OutputStream
	 * 
	 * @param path
	 * @param type
	 * @param from
	 * @param to
	 * @return OutputStream
	 */
	public OutputStream translateDocument(InputStream input, FileType type, SourceLanguage from, TargetLanguage to) {
		throw new UnsupportedOperationException("The method are not ready yet.");
	}

	public static class Builder {

		private String authKey;
		private int connectTimeout;
		private int readTimeout;
		private int repetitions;
		private TranslationOptions translationOptions;

		public Builder() {
			connectTimeout = 5000;
			readTimeout = 10000;
			repetitions = 3;
		}

		public Builder setAuthKey(String authKey) {
			this.authKey = authKey;
			return this;
		}

		public Builder setConnectTimeout(int connectTimeout) {
			this.connectTimeout = connectTimeout;
			return this;
		}

		public Builder setReadTimeout(int readTimeout) {
			this.readTimeout = readTimeout;
			return this;
		}

		public Builder setRepetitions(int repetitions) {
			this.repetitions = repetitions;
			return this;
		}

		public Builder withOptions(TranslationOptions translationOptions) {
			this.translationOptions = translationOptions;
			return this;
		}

		public Translator build() {
			return new Translator(authKey, connectTimeout, readTimeout, repetitions, translationOptions);
		}

	}
}
