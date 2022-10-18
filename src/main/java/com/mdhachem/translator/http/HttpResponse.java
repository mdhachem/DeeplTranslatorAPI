package com.mdhachem.translator.http;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class HttpResponse {

	private String responseContent;
	private int status;

	public HttpResponse(String responseContent, int status) {
		super();
		this.responseContent = responseContent;
		this.status = status;
	}

	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
