package com.escom.distribuidos.p2.p2desktop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.escom.distribuidos.p2.p2desktop.frames.MainFrame;

public class App {

	public static void main(String[] args) {
		String[] contextPaths = new String[] { "/spring.xml" };
		ClassPathXmlApplicationContext contexto = new ClassPathXmlApplicationContext(contextPaths);
		MainFrame mainFrame = (MainFrame) contexto.getBean("mainFrame");
		mainFrame.init();
	}

}
