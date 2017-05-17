package com.escom.distribuidos.p2.core.email;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.escom.distribuidos.p2.core.dto.ExamenDto;
import com.lowagie.text.DocumentException;

@Component
public class PDFRenderHelper {

	@Autowired
	private HtmlRenderHelper renderHelper;

	public ByteArrayOutputStream getExamenPDF(ExamenDto dto) {

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("examen", dto);
		model.put("dateFormat", new SimpleDateFormat("dd-MM-yyyy"));

		String html = renderHelper.renderExamen(model);
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {

			byteArrayOutputStream = new ByteArrayOutputStream();
			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(html);
			renderer.layout();
			renderer.createPDF(byteArrayOutputStream, false);
			renderer.finishPDF();

		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			if (byteArrayOutputStream != null) {
				try {
					byteArrayOutputStream.close();
				} catch (IOException e) {
				}
			}
		}
		return byteArrayOutputStream;
	}
}
