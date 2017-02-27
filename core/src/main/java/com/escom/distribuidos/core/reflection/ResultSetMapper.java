package com.escom.distribuidos.core.reflection;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.escom.distribuidos.core.annotations.Column;
import com.escom.distribuidos.core.annotations.Entity;

public class ResultSetMapper<T> {

	private void setProperty(Object clazz, String fieldName, Object columnValue) {
		try {
			Field field = clazz.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(clazz, columnValue);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> mapRersultSetToObject(ResultSet rs, Class clazz) {
		List<T> outputList = null;
		try {
			if (rs != null) {

				if (clazz.isAnnotationPresent(Entity.class)) {
					ResultSetMetaData rsmd = rs.getMetaData();

					Field[] fields = clazz.getDeclaredFields();

					while (rs.next()) {
						T bean = (T) clazz.newInstance();
						for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {
							String columnName = rsmd.getColumnName(_iterator + 1);

							Object columnValue = rs.getObject(_iterator + 1);

							for (Field field : fields) {
								if (field.isAnnotationPresent(Column.class)) {
									Column column = field.getAnnotation(Column.class);
									if (column.name().equalsIgnoreCase(columnName) && columnValue != null) {
										this.setProperty(bean, field.getName(), columnValue);
										break;
									}
								}
							}
						}
						if (outputList == null) {
							outputList = new ArrayList<T>();
						}
						outputList.add(bean);
					}
				} else {

				}
			} else {
				// ResultSet is empty
				return null;
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

		return outputList;
	}
}
