package com.escom.distribuidos.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LocalProperties {

	private Properties props = new Properties();
	private InputStream inputStream = null;
	private static LocalProperties INSTANCE;

	private LocalProperties() {
		try
		{
			inputStream = getClass().getClassLoader().getResourceAsStream("app.properties");
			props.load(inputStream);

		} catch (IOException ex)
		{
			ex.printStackTrace();
		}finally
		{
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String getProp(String prop) {
		return this.props.getProperty(prop);
	}

	public static LocalProperties getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new LocalProperties();
		}
		return INSTANCE;
	}
}
