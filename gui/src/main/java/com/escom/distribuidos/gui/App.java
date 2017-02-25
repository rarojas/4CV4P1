package com.escom.distribuidos.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class App {

	private JFrame frame;

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// SplashScreenMain splash = new SplashScreenMain();

					App window = new App();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public App() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu archivoMenu = new JMenu("Archivo");
		menuBar.add(archivoMenu);


		JMenuItem alumnosMenuItem = new JMenuItem("Alumnos");
		alumnosMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AlumnosFrame frame = new AlumnosFrame();
				frame.setVisible(true);
				desktopPane.add(frame);
			}
		});
		archivoMenu.add(alumnosMenuItem);

		JMenuItem salirMenuItem = new JMenuItem("Salir");
		salirMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		archivoMenu.add(salirMenuItem);

	}

}
