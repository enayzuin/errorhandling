package errorhandling.domain;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ExceptionModel {
	String msg;
	String code;
	@JsonIgnore
	HttpStatus status;


	public ExceptionModel(String msg, String code, HttpStatus status) {
		super();
		this.msg = msg;
		this.code = code;
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
