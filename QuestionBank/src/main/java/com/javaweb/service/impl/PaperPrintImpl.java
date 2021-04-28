package com.javaweb.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.javaweb.service.IPaperPrint;
import com.javaweb.vo.QuestionPrint;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class PaperPrintImpl implements IPaperPrint {
	private static final String[] ANSWER_MAP = new String[] 
			{"D","C","CD","B","BD","BC","BCD","A","AD","AC","ACD","AB","ABD","ABD","ABCD"};
	private static final String FILE = "D:\\Program\\apache-tomcat-10.0.4\\webapps\\QuestionBank\\download\\paper.docx";
	
	@Override
	public boolean createPaperDocument(List<QuestionPrint> qps) {
		// TODO Auto-generated method stub 	
		if (qps == null || qps.size() == 0) {
			return false;
		}
		@SuppressWarnings("resource")
		XWPFDocument document = new XWPFDocument();
        OutputStream stream = null;
        BufferedOutputStream bufferStream = null;
        try {
            File dirname = new File(FILE);
            System.out.println(dirname.exists());
            if (!dirname.exists()) {
                dirname.mkdirs();
            }
            stream = new FileOutputStream(dirname);
            //创建512字节缓冲区
            bufferStream = new BufferedOutputStream(stream, 512);
            // 创建一个段落
            XWPFParagraph p1 = document.createParagraph();
            // 设置居中
            p1.setAlignment(ParagraphAlignment.CENTER);
            System.out.println(2);
            XWPFRun r1 = p1.createRun();
           // 是否加粗
            r1.setBold(true);
            // 与下一行的距离
            r1.setTextPosition(20);
            r1.setText("试卷");
            // 字体大小
            r1.setFontSize(24);// 字体大小
            // 增加换行
            r1.addCarriageReturn();     
            // 创建新段落   
            XWPFParagraph p2 = document.createParagraph();
            XWPFRun r2 = p2.createRun();
            int i= 1;
            for(QuestionPrint qp : qps) {
                r2.setText(i + "、" + qp.getContent());
                r2.addCarriageReturn();
                r2.setText("(A) " + qp.getOptions()[0]);
                r2.addCarriageReturn();
                r2.setText("(B) " + qp.getOptions()[1]);
                r2.addCarriageReturn();
                r2.setText("(C) " + qp.getOptions()[2]);
                r2.addCarriageReturn();
                r2.setText("(D) " + qp.getOptions()[3]);
                r2.addCarriageReturn();
                r2.setText("答案为： "+ANSWER_MAP[qp.getAnswer() - 1]);
                r2.addCarriageReturn();
                r2.addCarriageReturn();               
                i++;
            }
            r2.setFontFamily("仿宋");		// 设置字体
            r2.setFontSize(12);		// 字体大小
            document.write(stream);
            stream.close();
            bufferStream.close();
        } catch (Exception ex) {
            return false;
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferStream != null) {
                try {
                    bufferStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } return true;	
	}
}
