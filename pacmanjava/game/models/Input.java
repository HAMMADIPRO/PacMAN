/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 15 Sep 2019 at 09:55:57
 */
package models;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import Threads.AudioThread;
import Threads.RenderThread;
import gfx.Maze;
import gfx.Pacman;
import gfx.Ui;
import pacmanjava.Sprite;

public class Input implements ActionListener, KeyListener {


	Pacman pacman;
	boolean go=true;
	public static boolean ESCAPE=false;

	public static boolean pause=false;
	public static boolean inputResume=false;
	public static boolean  help=false;
	public static boolean  audio=false;
	public static boolean  play=false;
	public static boolean  A=false;
	public static boolean P=true;
	public static boolean  H=false;
	public static boolean  E=false;


	private final int SLEEP_TIMER_1=5;
	private final int SLEEP_TIMER_2=3000;
	
	
	public static String musicOnOff ="ON";
	public static String musicOnOffS ="ON";
	public static int count = 0;
	public static int son = 0;
	public static int sonS= 0;
	public static int countS;
	

	public Input(RenderThread game, Pacman pacman) {

		game.addKeyListener(this);
		this.pacman=pacman;

	}




	public enum Direction{
		stop, up,down,right,left
	}
	public Direction dir;



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub


	}
 
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub


		int c =e.getKeyCode();
		
		
		if(c==KeyEvent.VK_M&& RenderThread.state==RenderThread.STATE.Game) {
			if(musicOnOff.equals("OFF")) {

				RenderThread.audiothreadMusic = new AudioThread(".//res//pacman_beginning.wav");
				RenderThread.audiothreadMusic.setMusic(true);
				RenderThread.audiothreadMusic.start();
				synchronized(RenderThread.audiothreadMusic) {
					try {
						RenderThread.audiothreadMusic.wait(5);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				RenderThread.audiothreadMusic.setMuteo(false);
				RenderThread.audiothreadMusic.setVolM(count);
			
				musicOnOff="ON";
				
			}

			else if(musicOnOff.equals("ON")) {

				RenderThread.audiothreadMusic.stopAudioThread();
				try {
					RenderThread.audiothreadMusic.join(15);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (RenderThread.audiothreadMusic.isAlive())
				{
					RenderThread.audiothreadMusic.interrupt();
				}
				RenderThread.audiothreadMusic.setMuteo(true);
				
				musicOnOff="OFF";		
			}
		


		}
		if(c==KeyEvent.VK_RIGHT && RenderThread.state==RenderThread.STATE.Audio && A) {
			
			sonS = RenderThread.audiothreadSound.getVolS() + 5;
			countS = sonS;

			if(sonS>=100) {
				sonS = 100;
			}
			RenderThread.audiothreadSound.setVolS(sonS);
			RenderThread.audiothreadSound.setVolume(sonS);
			
			try {
				Thread.sleep(SLEEP_TIMER_1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			
			
		}
		if(c==KeyEvent.VK_LEFT && RenderThread.state==RenderThread.STATE.Audio && A) {
			
			sonS = RenderThread.audiothreadSound.getVolS() - 5;
			countS = sonS;

			if(sonS<=0) {
				sonS = 0;
			}
			RenderThread.audiothreadSound.setVolS(sonS);
			RenderThread.audiothreadSound.setVolume(sonS);
			try {
				Thread.sleep(SLEEP_TIMER_1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
		}
		
		
		if(c==KeyEvent.VK_RIGHT && RenderThread.state==RenderThread.STATE.Audio && P) {

			son = RenderThread.audiothreadMusic.getVolM() + 5;
			count = son;

			if(son>=100) {
				son = 100;
			}
			RenderThread.audiothreadMusic.setVolM(son);
			RenderThread.audiothreadMusic.setVolume(son);
			
			try {
				Thread.sleep(SLEEP_TIMER_1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		}

		if(c==KeyEvent.VK_LEFT && RenderThread.state==RenderThread.STATE.Audio && P) {
			
			son = RenderThread.audiothreadMusic.getVolM() - 5;
			count = son;

			if(son<=0) {
				son = 0;
			}
			RenderThread.audiothreadMusic.setVolM(son);
			RenderThread.audiothreadMusic.setVolume(son);
			try {
				Thread.sleep(SLEEP_TIMER_1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		
		}
		
		if(c==KeyEvent.VK_ENTER&&RenderThread.state==RenderThread.STATE.Audio&&H) {

			if(musicOnOff.equals("OFF")) {
				

				RenderThread.audiothreadMusic = new AudioThread(".//res//pacman_beginning.wav");
				RenderThread.audiothreadMusic.setMusic(true);
				RenderThread.audiothreadMusic.start();
				synchronized(RenderThread.audiothreadMusic) {
					try {
						RenderThread.audiothreadMusic.wait(5);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				RenderThread.audiothreadMusic.setMuteo(false);
				RenderThread.audiothreadMusic.setVolM(count);

				
				
				
				musicOnOff="ON";
				
			}

			else if(musicOnOff.equals("ON")) {

				RenderThread.audiothreadMusic.stopAudioThread();
				try {
					RenderThread.audiothreadMusic.join(15);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (RenderThread.audiothreadMusic.isAlive())
				{
					RenderThread.audiothreadMusic.interrupt();
				}
				RenderThread.audiothreadMusic.setMuteo(true);
				
				
				
					
				musicOnOff="OFF";		
			}
	
		}
		
		if(c==KeyEvent.VK_ENTER&&RenderThread.state==RenderThread.STATE.Audio&&E) {

			if(musicOnOffS.equals("OFF")) {
				
				RenderThread.audiothreadSound = new AudioThread(".//res//pacman_chomp 2.wav");
				RenderThread.audiothreadSound.setMusic(true);
				RenderThread.audiothreadSound.start();
				synchronized(RenderThread.audiothreadSound) {
					try {
						RenderThread.audiothreadSound.wait(5);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				RenderThread.audiothreadSound.setMuteo(false);
				RenderThread.audiothreadSound.setVolS(countS);
			
				musicOnOffS="ON";
				
			}

			else if(musicOnOffS.equals("ON")) {

				RenderThread.audiothreadSound.stopAudioThread();
				try {
					RenderThread.audiothreadSound.join(15);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (RenderThread.audiothreadSound.isAlive())
				{
					RenderThread.audiothreadSound.interrupt();
				}
				RenderThread.audiothreadSound.setMuteo(true);

				musicOnOffS="OFF";		
			}
		}
		
	
		
		if(c==KeyEvent.VK_M&& RenderThread.state==RenderThread.STATE.Game) {
			if(musicOnOff.equals("OFF")) {

				RenderThread.audiothreadMusic = new AudioThread(".//res//pacman_beginning.wav");
				RenderThread.audiothreadMusic.setMusic(true);
				RenderThread.audiothreadMusic.start();
				synchronized(RenderThread.audiothreadMusic) {
					try {
						RenderThread.audiothreadMusic.wait(5);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				RenderThread.audiothreadMusic.setMuteo(false);
				RenderThread.audiothreadMusic.setVolM(count);
			
				musicOnOff="ON";
				
			}

			else if(musicOnOff.equals("ON")) {

				RenderThread.audiothreadMusic.stopAudioThread();
				try {
					RenderThread.audiothreadMusic.join(15);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				if (RenderThread.audiothreadMusic.isAlive())
				{
					RenderThread.audiothreadMusic.interrupt();
				}
				RenderThread.audiothreadMusic.setMuteo(true);
				
				musicOnOff="OFF";		
			}
		}
		
		if(c==KeyEvent.VK_RIGHT && RenderThread.state==RenderThread.STATE.Menu) {

			son = RenderThread.audiothreadMusic.getVolM() + 5;
			count = son;

			if(son>=100) {
				son = 100;
			}
			RenderThread.audiothreadMusic.setVolM(son);
			RenderThread.audiothreadMusic.setVolume(son);
			

		}

		if(c==KeyEvent.VK_LEFT && RenderThread.state==RenderThread.STATE.Menu) {

			son = RenderThread.audiothreadMusic.getVolM() - 5;
			count = son;

			if(son<=0) {
				son = 0;
			}
			RenderThread.audiothreadMusic.setVolM(son);
			RenderThread.audiothreadMusic.setVolume(son);

		
		}


		if(c==KeyEvent.VK_P&&RenderThread.state==RenderThread.STATE.Game) {
			pause=true;

		}


		if(c==KeyEvent.VK_ENTER&&RenderThread.state==RenderThread.STATE.Menu ) {
			RenderThread.state=RenderThread.STATE.Game;
			ESCAPE=false;
			help=false;
			play=true;
			audio=false;



		}

		if(c==KeyEvent.VK_R&&RenderThread.state==RenderThread.STATE.Game  ) {
			pause=false;
			inputResume=true;
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}	

		}

		inputResume=false;

		if(pause==false) {




			if(c==KeyEvent.VK_LEFT&&Ui.tunnelleft()) {
			
				pacman.setDirection("LEFT");	
				
			}


			if(c==KeyEvent.VK_RIGHT&&Ui.tunneright()) {
			
				pacman.setDirection("RIGHT");

			}


			if(c==KeyEvent.VK_UP) {
				
				
				
			
				pacman.setDirection("UP");	
				
				

			}


			if(c==KeyEvent.VK_DOWN) {
			
				pacman.setDirection("DOWN");

			}

		}



		if(c==KeyEvent.VK_ESCAPE&&!H&&!A) {

			RenderThread.state=RenderThread.STATE.Menu;
			ESCAPE=true;
		}


		if(c==KeyEvent.VK_ENTER&&H==true) {

			RenderThread.state=RenderThread.STATE.Help;
			help=true;
		}
		
		
		
		
		if(c==KeyEvent.VK_ENTER&&E) {

			System.exit(0);
			
		}
		
		if(P&&play&&c==KeyEvent.VK_ENTER&&RenderThread.state==RenderThread.STATE.Menu  ) {
			RenderThread.state=RenderThread.STATE.Game;
		}

		if((c==KeyEvent.VK_DOWN&&RenderThread.state==RenderThread.STATE.Menu)||(c==KeyEvent.VK_DOWN&&RenderThread.state==RenderThread.STATE.Audio)) {
			if(P==true) { A=true;P=false;}
			else if(A==true) { H=true;A=false;}
			else if(H==true) { E=true;H=false;}
			else if(E==true) { P=true;E=false;}
		}
		if((c==KeyEvent.VK_UP&&RenderThread.state==RenderThread.STATE.Menu)||(c==KeyEvent.VK_UP&&RenderThread.state==RenderThread.STATE.Audio)) {
			if(P==true) { E=true;P=false;}
			else if(E==true) { H=true;E=false;}
			else if(H==true) { A=true;H=false;}
			else if(A==true) { P=true;A=false;}
	}
		
		
		if(c==KeyEvent.VK_ENTER &&A==true) {
			RenderThread.state=RenderThread.STATE.Audio;
			audio=true;
			
		}
		if(c==KeyEvent.VK_B&&H==true) {
			RenderThread.state=RenderThread.STATE.Menu;
		}
		if(c==KeyEvent.VK_B&&A==true) {
			RenderThread.state=RenderThread.STATE.Menu;
		}
		
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		pacman.changed=false;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


	}


}


