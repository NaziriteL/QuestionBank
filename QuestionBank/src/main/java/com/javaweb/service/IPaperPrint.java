package com.javaweb.service;

import java.util.List;
import com.javaweb.vo.QuestionPrint;

public interface IPaperPrint {
	/*
	 * ����ѡ���Ծ��word�ĵ����ɹ�����r=true,���򷵻�false
	 */
	public boolean createPaperDocument(List<QuestionPrint> qps);
}
