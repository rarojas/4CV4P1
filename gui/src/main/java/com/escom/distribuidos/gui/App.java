package com.escom.distribuidos.gui;

import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker.StateValue;

import com.escom.distribuidos.gui.splash.SplashScreenMain;

public class App {

	private JFrame frame;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					final SplashScreenMain splash = new SplashScreenMain();
					splash.addPropertyChangeListener(new PropertyChangeListener() {
						@Override
						public void propertyChange(PropertyChangeEvent evt) {
							if (evt.getPropertyName() == "state")
								if ((StateValue) evt.getNewValue() == StateValue.DONE)
									SwingUtilities.invokeLater(new Runnable() {
										@Override
										public void run() {
											App app = new App();
											app.frame.setVisible(true);
										}
									});
						}
					});
					splash.execute();

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

		frame = new MainFrame();

	}

}
