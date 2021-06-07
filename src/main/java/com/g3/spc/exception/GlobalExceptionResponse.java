package com.g3.spc.exception;

public class GlobalExceptionResponse {
	private int httpStatus;
	private String exceptionMsg;
	
	public GlobalExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GlobalExceptionResponse(int httpStatus, String exceptionMsg) {
		super();
		this.httpStatus = httpStatus;
		this.exceptionMsg = exceptionMsg;
	}
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getExceptionMsg() {
		return exceptionMsg;
	}
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
}