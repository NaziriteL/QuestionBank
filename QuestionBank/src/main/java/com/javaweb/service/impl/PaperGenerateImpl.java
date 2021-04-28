package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.javaweb.vo.AutoPaper;
import com.javaweb.vo.QuestionPrint;
import com.javaweb.dbc.DBConnection;
import com.javaweb.factory.DAOFactory;
import com.javaweb.service.IPaperGenerate;


public class PaperGenerateImpl implements IPaperGenerate {
	private DBConnection dbc = new DBConnection();
	@Override
	public List<QuestionPrint> getAutoPaper(AutoPaper ap) throws Exception {
		// TODO Auto-generated method stub
		int cnt = ap.getBlockAmount();
		List<QuestionPrint> res = new ArrayList<QuestionPrint>();
		try {
			for(int i = 0; i < cnt; i++) {
				if(DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).getAutoBlockByRequest(ap.getBlocks()[i]) == null) {
					return null;
				}
				res.addAll(DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).getAutoBlockByRequest(ap.getBlocks()[i]));
			}
			return res;
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
	
	@Override
	public List<QuestionPrint> getManualPaper(List<Integer> ids) throws Exception{
		// TODO Auto-generated method stub
		try {
			return DAOFactory.getIQuestionDAOInstance(this.dbc.getConnection()).getManualPaperQuestion(ids);
		} catch(Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
	}
}
