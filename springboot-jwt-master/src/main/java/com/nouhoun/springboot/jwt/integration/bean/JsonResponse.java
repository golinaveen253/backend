package com.nouhoun.springboot.jwt.integration.bean;

import java.util.List;

public class JsonResponse {
	private String response_status;
	private String response_message;
	private List<?> data;

	public String getResponse_status() {
		return response_status;
	}

	public void setResponse_status(String response_status) {
		this.response_status = response_status;
	}

	public String getResponse_message() {
		return response_message;
	}

	public void setResponse_message(String response_message) {
		this.response_message = response_message;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

}
