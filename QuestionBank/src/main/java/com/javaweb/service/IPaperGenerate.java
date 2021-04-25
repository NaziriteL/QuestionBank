package com.javaweb.service;

import com.javaweb.vo.AutoPaper;
import com.javaweb.vo.QuestionPrint;

import java.util.List;

public interface IPaperGenerate {
	/*
	 * 自动生成试卷方法
	 */
	public List<QuestionPrint> getAutoPaper(AutoPaper ap) throws Exception;
	/*
	 * 手动生成试卷方法
	 */
	public List<QuestionPrint> getManualPaper(List<Integer> ids) throws Exception;
}
