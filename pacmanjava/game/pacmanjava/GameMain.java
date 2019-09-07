package pacmanjava;


import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameMain {
	
	
	
	public static void main(String[] args) {
		
		JFrame window=new JFrame();
		JPanel game= new GamePanel();
		Screen.setScreen(window,game,"Pacman");

		
		
		//Screen.setFullScreen();

	}

}
