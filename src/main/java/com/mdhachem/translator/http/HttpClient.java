package com.mdhachem.translator.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

import com.mdhachem.exception.TranslatorException;
import com.mdhachem.exception.UnauthorizedException;
import com.mdhachem.translator.SourceLanguage;
import com.mdhachem.translator.TargetLanguage;
import com.mdhachem.translator.service.Translator;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class HttpClient {

	private static final String BASE_URL = "https://api.deepl.com/v1/translate?auth_key={0}&text={1}&target_lang={2}";
	private static final String HTTP_POST_METHOD = "POST";

	private HttpClient() {

	}

	public static HttpResponse translate(Translator translator, String text, SourceLanguage from, TargetLanguage to) {

		try {
			URLConnection con = new URL(getUrlAsString(translator.getAuthKey(), text, from, to)).openConnection();
			HttpURLConnection http = buildHttpConnection(translator, con);
			int status = http.getResponseCode();
			return new HttpResponse(getRequestResponse(http, status).toString(), status);
		} catch (IOException ex) {
			throw new TranslatorException(
					"An error occurred when trying to connect and getting response from the server.", ex);
		}
	}

	private static HttpURLConnection buildHttpConnection(Translator translator, URLConnection con)
			throws ProtocolException {
		HttpURLConnection http = (HttpURLConnection) con;
		http.setRequestMethod(HTTP_POST_METHOD);
		http.setDoOutput(true);
		http.setRequestProperty("Content-Language", "en-US");
		http.setRequestProperty("User-Agent", "Mozilla/5.0");
		http.setConnectTimeout(translator.getConnectTimeout());
		http.setReadTimeout(translator.getReadTimeout());
		return http;
	}

	private static StringBuilder getRequestResponse(HttpURLConnection http, int status) throws IOException {
		BufferedReader reader;
		String line;
		StringBuilder responseContent = new StringBuilder();
		if (status == 403) {
			throw new UnauthorizedException("Invalid Authentication Key");
		} else if (status >= 300) {
			reader = new BufferedReader(new InputStreamReader(http.getErrorStream()));
			while ((line = reader.readLine()) != null) {
				responseContent.append(line);
			}
			reader.close();
		} else {
			reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
			while ((line = reader.readLine()) != null) {
				responseContent.append(line);
			}
			reader.close();
		}
		return responseContent;
	}

	private static String getUrlAsString(String authKey, String text, SourceLanguage from, TargetLanguage to) {
		return MessageFormat.format(BASE_URL, authKey, URLEncoder.encode(text, StandardCharsets.UTF_8),
				to.getLanguageCode(), from != null ? "&source_lang=" + from.getLanguageCode() : "");
	}
}
