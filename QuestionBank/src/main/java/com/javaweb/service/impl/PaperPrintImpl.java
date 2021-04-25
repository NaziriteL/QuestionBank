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
	private static final String FILE = "/download/paper.docx";
	
	@Override
	public boolean createPaperDocument(List<QuestionPrint> qps) {
		// TODO Auto-generated method stub 	
		if (qps == null) {
			return false;
		}
		@SuppressWarnings("resource")
		XWPFDocument document = new XWPFDocument();
        OutputStream stream = null;
        BufferedOutputStream bufferStream = null;
        try {
            File dir = new File(FILE);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            stream = new FileOutputStream(dir);
            //����512�ֽڻ�����
            bufferStream = new BufferedOutputStream(stream, 512);
            // ����һ������
            XWPFParagraph p1 = document.createParagraph();
            // ���þ���
            p1.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun r1 = p1.createRun();
           // �Ƿ�Ӵ�
            r1.setBold(true);
            // ����һ�еľ���
            r1.setTextPosition(30);
            r1.setText("�Ծ�");
            // �����С
            r1.setFontSize(18);// �����С
            // ���ӻ���
            r1.addCarriageReturn();            
            
            int i= 1;
            for(QuestionPrint qp : qps) {
            	// �����¶���       	
                XWPFParagraph p2 = document.createParagraph();
                XWPFRun r2 = p2.createRun();
                r2.setText(i + "��" + qp.getContent());
                r2.addCarriageReturn();
                r2.setText('A' + qp.getOptions()[0]);
                r2.addCarriageReturn();
                r2.setText('B' + qp.getOptions()[1]);
                r2.addCarriageReturn();
                r2.setText('C' + qp.getOptions()[2]);
                r2.addCarriageReturn();
                r2.setText('D' + qp.getOptions()[3]);
                r2.addCarriageReturn();
                r2.setText("��Ϊ�� "+ANSWER_MAP[qp.getAnswer() - 1]);
                r2.addCarriageReturn();
                r2.addCarriageReturn();
                r2.setFontFamily("����");		// ��������
                r2.setFontSize(14);		// �����С
                document.write(stream);
                i++;
            }
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
        }
		return true;
	}
}