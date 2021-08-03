package com.spm.inventory.model;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.core.Conventions;

/*
 * Created by Manuka Yasas (IT19133850)
 * manukayasas99@gmail.com
 */
public class ResponseData {
	private boolean success;
	private String message;
	Map<String, Object> data;

	public ResponseData() {
		super();
		this.data = new TreeMap<>();
		this.success = false;
	}

	public ResponseData(boolean success) {
		super();
		this.success = success;
		this.data = new TreeMap<>();
	}

	public ResponseData(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
		this.data = new TreeMap<>();
	}

	public ResponseData(boolean success, String message, Map<String, Object> data) {
		super();
		this.success = success;
		this.message = message;

		if (data != null)
			this.data = data;
		else
			this.data = new TreeMap<>();
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public boolean issuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void putToData(String name, Object data) {
		this.data.put(name, data);
	}

	public void putToData(Object attributeValue) {
		this.data.put(Conventions.getVariableName(attributeValue), attributeValue);
	}
}
