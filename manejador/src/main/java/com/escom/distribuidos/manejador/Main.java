package com.escom.distribuidos.manejador;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker.StateValue;

import com.escom.distribuidos.gui.splash.SplashScreenMain;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1805883170760505544L;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		final SplashScreenMain splash = new SplashScreenMain();
		splash.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName() == "state")
					if ((StateValue) evt.getNewValue() == StateValue.DONE)
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								Main app = new Main();
								app.setVisible(true);
							}
						});
			}
		});
		splash.execute();
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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

			@Override
			public void actionPerformed(ActionEvent e) {

				ManejadorFrame frame = ManejadorFrame.getInstance();
				if (frame.isVisible()) {
					frame.toFront();

				} else {
					desktopPane.add(frame);
					frame.setVisible(true);
				}
			}
		});
		accionesMenu.add(manejadorItemn);

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
