/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 15 Sep 2019 at 23:26:41
 */
package models;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import gfx.Pacman;
import pacmanjava.GamePanel;



public class GameState  implements WindowListener  , WindowFocusListener, WindowStateListener {
	
	

	

	public static boolean state =false;
	public static boolean focus=false ;
	public static boolean iconified=true;
	
	
	
	
	

	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		iconified=true;
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
		focus=true;
		iconified=false;
		
	
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		 focus=true;
		
		 
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		 focus=false;
			
	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		state=true;
		
		
	}
	
	
	public static void sleep(int i) {
		
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
    
	
	

}
