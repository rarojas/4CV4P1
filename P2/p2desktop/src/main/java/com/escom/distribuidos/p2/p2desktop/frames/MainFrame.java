package com.escom.distribuidos.p2.p2desktop.frames;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mainFrame")
public class MainFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 7025545913268123936L;

	@Autowired
	private AlumnosFrame alumnosFrame;
	private JDesktopPane desktopPane;

	public MainFrame() {
		super();
		setTitle("Main");
		setSize(640, 480);

		desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu archivoMenu = new JMenu("Archivo");
		menuBar.add(archivoMenu);

		JMenu accionesMenu = new JMenu("Acciones");
		menuBar.add(accionesMenu);

		JMenuItem manejadorItemn = new JMenuItem("Manejador");
		manejadorItemn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (alumnosFrame.isVisible()) {
					alumnosFrame.toFront();

				} else {
					alumnosFrame.init();
					alumnosFrame.setVisible(true);
					desktopPane.add(alumnosFrame);

				}
			}
		});
		accionesMenu.add(manejadorItemn);
		JMenuItem salirMenuItem = new JMenuItem("Salir");
		salirMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		archivoMenu.add(salirMenuItem);
	}

	public void init() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

}
