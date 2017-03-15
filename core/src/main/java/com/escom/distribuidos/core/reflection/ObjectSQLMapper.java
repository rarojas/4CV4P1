package com.escom.distribuidos.core.reflection;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.escom.distribuidos.core.annotations.Column;
import com.escom.distribuidos.core.annotations.Entity;
import com.escom.distribuidos.core.annotations.Id;

public class ObjectSQLMapper<T> {

	public String mapObjectToInsertSQL(T entity, Class<?> clazz) {
		String result = "";
		if (clazz.isAnnotationPresent(Entity.class)) {
			Field[] fields = clazz.getDeclaredFields();
			result = result.concat("(");
			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(Id.class)) {
					Column column = field.getAnnotation(Column.class);
					result = result.concat(column.name()).concat(",");
				}
			}
			result = result.concat(") values (").replace(",)", ")");
			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(Id.class)) {
					Class<?> fieldType = field.getType();
					String value = "";
					Object valueObj;
					try {
						field.setAccessible(true);
						valueObj = field.get(entity);
						if (fieldType.equals(String.class)) {
							value = "'" + (String) valueObj + "'";
						}
						if (fieldType.equals(int.class)) {
							value = ((Integer) valueObj).toString();
						}
						if(fieldType.equals(Date.class)) {
							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							value = "'" + df.format(((Date) valueObj)) + "'";
						}
						if(fieldType.equals(BigDecimal.class)) {
							value = ((BigDecimal) valueObj).toString();
						}
						result = result.concat(value).concat(",");

					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			result = result.concat(")").replace(",)", ")");
		}
		return result;
	}

	public String mapObjectToUpdateSQL(T entity, Class<?> clazz) {
		String result = " set ";
		if (clazz.isAnnotationPresent(Entity.class)) {
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(Id.class)) {
					Column column = field.getAnnotation(Column.class);
					result = result.concat(column.name()).concat(" = ");
					Class<?> fieldType = field.getType();
					String value = "";
					Object valueObj;
					try {
						field.setAccessible(true);
						valueObj = field.get(entity);
						if (fieldType.equals(String.class)) {
							value = "'" + (String) valueObj + "'";
						}
						if (fieldType.equals(int.class)) {
							value = ((Integer) valueObj).toString();
						}
						if(fieldType.equals(Date.class)) {
							DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
							value = "'" + df.format(((Date) valueObj)) + "'";
						}
						if(fieldType.equals(BigDecimal.class)) {
							value = ((BigDecimal) valueObj).toString();
						}
						result = result.concat(value).concat(",");

					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
			result = result.concat("where ").replace(",w", " w");
			for (Field field : fields) {
				if (field.isAnnotationPresent(Id.class)) {
					field.setAccessible(true);
					Integer valueObj;
					try {
						valueObj = (Integer) field.get(entity);
						result = result.concat(field.getName()).concat(" = ").concat(valueObj.toString());
					} catch (IllegalArgumentException | IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return result;
	}
}
