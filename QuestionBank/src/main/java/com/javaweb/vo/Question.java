package com.javaweb.vo;

import java.io.Serializable;

public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String mainTitle;
	private String subTitle;
	private String content;
	private String[] options;	
	private Integer answer;
	private Integer difficulty;
	private Boolean isMulti;
	
	public void setId(Integer id) {
		this.id = id; 
	}
	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	public void setIsMulti(Boolean isMulti) {
		this.isMulti = isMulti;
	}
	
	public Integer getId() {
		return id;
	}
	public String getMainTitle() {
		return mainTitle;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public String getContent() {
		return content;
	}
	public String[] getOptions() {
		return options;
	}
	public Integer getAnswer() {
		return answer;
	}
	public Integer getDifficulty() {
		return difficulty;
	}
	public Boolean getIsMulti() {
		return isMulti;
	}
	
}
