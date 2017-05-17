package com.escom.distribuidos.p2.core.services;

import com.escom.distribuidos.p2.core.dto.ExamenDto;
import com.escom.distribuidos.p2.core.model.Examen;

public interface ExamenServices extends ServiceBase<Examen, ExamenDto> {

	public byte[] getExamenPDF(Integer idExamen);

}
