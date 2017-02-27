package com.escom.distribuidos.core.reflection;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.escom.distribuidos.core.Context;
import com.escom.distribuidos.core.annotations.Controller;
import com.escom.distribuidos.core.annotations.RequestMapping;

public class ReflectionUtils {

	public static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}

	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		Map<String, Method> mappings = new HashMap<String, Method>();
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				Class clazz = Class
						.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
				Controller controller = (Controller) clazz.getAnnotation(Controller.class);
				if (controller != null) {
					classes.add(clazz);
					Method[] methods = clazz.getMethods();
					for (Method method : methods) {
						RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
						if (requestMapping != null) {
							String route = requestMapping.method().concat(" ");
							route = route.concat(controller.value()).concat("/").concat(requestMapping.value());
							mappings.put(route, method);
							System.out.print(route.concat(" -> "));
							System.out.println(method.getName());
						}
					}
				}

			}
		}
		Context.getInstance().setMappings(mappings);
		return classes;
	}
}
