package com.mdhachem.translator.persing;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class ErrorResponse {
	private String message;
	private String detail;

	public ErrorResponse(String message, String detail) {
		super();
		this.message = message;
		this.detail = detail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (message != null) {
			sb.append("message=");
			sb.append(message);
		}
		if (detail != null) {
			sb.append(", Detail=");
			sb.append(detail);
		}
		return sb.toString();
	}

}
