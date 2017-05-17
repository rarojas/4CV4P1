package com.escom.distribuidos.p2.webapp;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.escom.distribuidos.p2.core.dto.ExamenAlumnoDto;
import com.escom.distribuidos.p2.core.dto.ExamenDto;
import com.escom.distribuidos.p2.core.model.Examen;
import com.escom.distribuidos.p2.core.services.ExamenServices;

@RestController
@RequestMapping("examen")
public class ExamenController extends BaseController<Examen, ExamenDto> {

	private Logger logger = Logger.getLogger(ExamenController.class);

	private ExamenServices examenServices;

	@Autowired
	public void setAlumnoServices(ExamenServices examenServices) {
		this.serviceBase = examenServices;
		this.examenServices = examenServices;
	}

	@RequestMapping(value = "send", method = RequestMethod.POST)
	public void sendAnsweredExamen(@RequestBody ExamenAlumnoDto examenAlumnoDto) {
		logger.info(examenAlumnoDto.getExamen().getId());
	}

	@RequestMapping(value = "file/{idExamen}", method = RequestMethod.GET)
	public void getExamenPDF(@PathVariable("idExamen") Integer idExamen, HttpServletResponse response) {
		try {
			byte[] data = this.examenServices.getExamenPDF(idExamen);
			streamReport(response, data, "examen.pdf");
		} catch (IOException ex) {
			throw new RuntimeException("IOError writing file to output stream");
		}
	}

	protected void streamReport(HttpServletResponse response, byte[] data, String name) throws IOException {

		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + name);
		response.setContentLength(data.length);

		response.getOutputStream().write(data);
		response.getOutputStream().flush();
	}
}
