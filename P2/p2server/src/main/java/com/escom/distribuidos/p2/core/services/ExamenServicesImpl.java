package com.escom.distribuidos.p2.core.services;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escom.distribuidos.p2.core.dao.ExamenDao;
import com.escom.distribuidos.p2.core.dto.ExamenDto;
import com.escom.distribuidos.p2.core.email.PDFRenderHelper;
import com.escom.distribuidos.p2.core.model.Examen;

@Service
public class ExamenServicesImpl extends ServiceBaseImpl<Examen, ExamenDto> implements ExamenServices {

	public ExamenServicesImpl() {
		super(ExamenDto.class, Examen.class);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = 5115498093424039587L;

	@Autowired
	private PDFRenderHelper PDFRenderHelper;

	@Autowired
	private void setDao(ExamenDao examenDao) {
		this.dao = examenDao;
	}

	private ExamenDao getDao() {
		return (ExamenDao) this.dao;
	}

	@Override
	public byte[] getExamenPDF(Integer idExamen) {
		ExamenDto examen = this.get(idExamen);
		ByteArrayOutputStream outputStream = PDFRenderHelper.getExamenPDF(examen);
		if (outputStream == null)
			return null;
		return outputStream.toByteArray();
	}

}
