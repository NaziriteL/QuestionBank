package com.javaweb.service;

import com.javaweb.vo.AutoPaper;
import com.javaweb.vo.QuestionPrint;

import java.util.List;

public interface IPaperGenerate {
	/*
	 * �Զ������Ծ���
	 */
	public List<QuestionPrint> getAutoPaper(AutoPaper ap) throws Exception;
	/*
	 * �ֶ������Ծ���
	 */
	public List<QuestionPrint> getManualPaper(List<Integer> ids) throws Exception;
}
