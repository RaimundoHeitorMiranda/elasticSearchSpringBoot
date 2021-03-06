package com.rhm.estagio.response;

public class Response<T> {
	
	private T data;
	
	private String error;

	
	public Response() {
		
	}
	
	public Response(T data) {
		this.data = data;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	@Override
	public String toString() {
		return "Response [data=" + data + ", error=" + error + "]";
	}
		
}
