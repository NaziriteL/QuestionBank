package com.javaweb.vo;

import java.io.Serializable;

public class AutoBlock implements Serializable {
	private static final long serialVersionUID = 1L;
	private String mainTitle;
	private String subTitle;
	private Integer difficulty;
	private Integer questionAmount;
	private Boolean isMulti;
	
	public String getMainTitle() {
		return mainTitle;
	}
	public void setMainTitle(String mainTitle) {
		this.mainTitle = mainTitle;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public Integer getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}
	public Integer getQuestionAmount() {
		return questionAmount;
	}
	public void setQuestionAmount(Integer questionAmount) {
		this.questionAmount = questionAmount;
	}
	public Boolean getIsMulti() {
		return isMulti;
	}
	public void setIsMulti(Boolean isMulti) {
		this.isMulti = isMulti;
	}
}
