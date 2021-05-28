package com.javaweb.factory;

import com.javaweb.service.*;
import com.javaweb.service.impl.*;

public class ServiceFactory {
	public static IPaperPrint getIPaperPrintInstance() {
		return new PaperPrintImpl();
	}
	public static IUserService getIUserServiceInstance() {
		return new UserServiceImpl();
	}
	public static IPaperGenerate getIPaperGenerateInstance() {                                                                                                                                                               
		return new PaperGenerateImpl();
	}
	public static IQuestionOperate getIQuestionOperateInstance() {
		return new QuestionOperateImpl();
	}
}
