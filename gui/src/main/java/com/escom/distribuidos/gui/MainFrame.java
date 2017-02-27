package com.escom.distribuidos.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.escom.distribuidos.gui.frames.AlumnosFrame;
import com.escom.distribuidos.gui.frames.AsignacionFrame;
import com.escom.distribuidos.gui.frames.CursosFrame;

public class MainFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -1927832324432088540L;
	private JDesktopPane desktopPane;

	public MainFrame(){
		super("P1");
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu archivoMenu = new JMenu("Archivo");
		menuBar.add(archivoMenu);

		JMenu accionesMenu = new JMenu("Acciones");
		menuBar.add(accionesMenu);

		JMenuItem alumnosMenuItem = new JMenuItem("Alumnos");
		alumnosMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				AlumnosFrame frame = AlumnosFrame.getInstance();
				if (frame.isVisible()) {
					frame.toFront();

				} else {
					desktopPane.add(frame);
					frame.setVisible(true);
				}
			}
		});
		accionesMenu.add(alumnosMenuItem);

		JMenuItem cursosMenuItem = new JMenuItem("Curso");
		cursosMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				CursosFrame frame = CursosFrame.getInstance();
				if (frame.isVisible()) {
					frame.toFront();

				} else {
					desktopPane.add(frame);
					frame.setVisible(true);
				}
			}
		});
		accionesMenu.add(cursosMenuItem);

		JMenuItem asignacionMenuItem = new JMenuItem("Asignaciones");
		asignacionMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				AsignacionFrame frame = AsignacionFrame.getInstance();
				if (frame.isVisible()) {
					frame.toFront();

				} else {
					desktopPane.add(frame);
					frame.setVisible(true);
				}
			}
		});
		accionesMenu.add(asignacionMenuItem);

		JMenuItem salirMenuItem = new JMenuItem("Salir");
		salirMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		archivoMenu.add(salirMenuItem);

	}
}
