package com.dtech.api.tenant.model;

import java.time.LocalDateTime;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ApiResponse {

	private LocalDateTime localDateTime;
	private int status;
	private String message;
	private Object data;
	public ApiResponse(LocalDateTime localDateTime, int status, String message, Object data) {
		super();
		this.localDateTime = localDateTime;
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public ApiResponse() {
		super();
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
