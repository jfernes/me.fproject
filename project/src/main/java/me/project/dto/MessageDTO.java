package me.project.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable{
	private static final long serialVersionUID = 5164970597078628265L;
	private int code;
	private Object data;
	
	public MessageDTO() {}
	
	public MessageDTO(int code, Object data) {
		this.code = code;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
