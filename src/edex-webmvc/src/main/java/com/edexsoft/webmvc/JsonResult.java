package com.edexsoft.webmvc;

//import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonAutoDetect(JsonMethod.FIELD)
public class JsonResult {

	@JsonProperty("ResultCode")
	private int resultCode;
	@JsonProperty("ResultMessage")
	private String resultMessage;
	@JsonProperty("Data")
	// @JsonSerialize(include=Inclusion.NON_EMPTY) // 为null或""时，该字段不参与json序列化
	// @JsonIgnore
	private Object data;

	public JsonResult() {
		this.resultCode = 0;
		this.resultMessage = "";
		this.data = null;
	}

	public JsonResult(int resultCode, String resultMessage) {
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.data = null;
	}

	public JsonResult(int resultCode, String resultMessage, Object data) {
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
		this.data = data;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
