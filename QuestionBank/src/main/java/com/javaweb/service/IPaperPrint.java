package com.javaweb.service;

import java.util.List;
import com.javaweb.vo.QuestionPrint;

public interface IPaperPrint {
	/*
	 * 生成选定试卷的word文档，成功返回r=true,否则返回false
	 */
	public boolean createPaperDocument(List<QuestionPrint> qps);
}
