package pacmanjava;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen {
	public static GraphicsDevice gDevice;
	public static JFrame window;
	
	public static void setScreen( JFrame window,JPanel gameScreen, String title) {
		
		window.setTitle(title);
		window.setLocationRelativeTo(null);
		window.setSize(600,800);
		window.add(gameScreen);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public static void resize() {
	
		
	}
	
	
	public static void getScreen() {
		GraphicsEnvironment gEnvironment= GraphicsEnvironment.getLocalGraphicsEnvironment();	
		gDevice=  gEnvironment.getDefaultScreenDevice();
	}
	
	
	
	public static void setFullScreen() {
		getScreen();
		gDevice.setFullScreenWindow(window);
		
	}
	
	
	public void restoreScreen() {
		
	}

}
