package com.escom.distribuidos.p2.core.email;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.exceptions.JadeCompilerException;

@Component
public class HtmlRenderHelper {

	public String renderExamen(Map<String, Object> model) {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			return Jade4J.render(classLoader.getResource("templates/examen.jade").getPath(), model);

		} catch (JadeCompilerException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
