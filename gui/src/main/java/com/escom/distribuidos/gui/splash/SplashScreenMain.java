package com.escom.distribuidos.gui.splash;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import com.escom.distribuidos.cliente.Cliente;

public class SplashScreenMain extends SwingWorker<Integer, Integer> {

	SplashScreen screen;

	public SplashScreenMain() {
		splashScreenInit();
	}

	private void splashScreenDestruct() {
		screen.setScreenVisible(false);
	}

	private void splashScreenInit() {
		try {
			ImageIcon imageIcon = new ImageIcon(
					new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif"));
			screen = new SplashScreen(imageIcon);
			screen.setScreenVisible(true);
			screen.setAlwaysOnTop(true);
			screen.setLocationRelativeTo(null);
			screen.setProgressMax(100);
			screen.setProgress(0);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}
	@Override
	protected void done() {
		splashScreenDestruct();
		try {
			get();
		} catch (InterruptedException | ExecutionException e) {
			JOptionPane.showConfirmDialog(null, "Ocurrio un error al conectar el servidor");
			System.exit(0);
		}
	}

	@Override
	protected void process(List<Integer> chunks) {
		screen.setProgress(chunks.get(0));
	}

	@Override
	protected Integer doInBackground() throws Exception {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 80) {
				Cliente.getInstance();
			}
			publish(i);
		}
		return 1;
	}

}
