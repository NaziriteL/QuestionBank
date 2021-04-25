package com.javaweb.vo;

import java.io.Serializable;

public class QuestionPrint implements Serializable {
	private static final long serialVersionUID = 1L;
	private String content;
	private String[] options;	
	private Integer answer;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public Integer getAnswer() {
		return answer;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
}
