package com.escom.distribuidos.gui;

public class SplashScreenMain  {

	SplashScreen screen;

	public SplashScreenMain() {
		// initialize the splash screen
		splashScreenInit();
		// do something here to simulate the program doing something that
		// is time consuming
		for (int i = 0; i <= 100; i++) {
			for (long j = 0; j < 50000; ++j) {
				String poop = " " + (j + i);
			}
			// run either of these two -- not both
			screen.setProgress("Yo " + i, i); // progress bar with a message
			// screen.setProgress(i); // progress bar with no message
		}
		//splashScreenDestruct();
		// System.exit(0);
	}

	private void splashScreenDestruct() {
		screen.setScreenVisible(false);
	}

	private void splashScreenInit() {
		// ImageIcon myImage = new
		// ImageIcon(com.devdaily.splashscreen.SplashScreenMain.class.getResource("SplashImage.gif"));
		screen = new SplashScreen();
		screen.setLocationRelativeTo(null);
		screen.setProgressMax(100);
		screen.setScreenVisible(true);
	}

}
