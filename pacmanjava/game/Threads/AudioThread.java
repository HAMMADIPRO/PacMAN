package Threads;

import java.io.File;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import models.Input;


// code FPS AudioThread
/*AUDIOTHREAD=(isMuteO->setVolume->sleep->isRunning->AUDIOTHREAD |isNotMuteO->MUSIC),
MUSIC= (isMusic->setVol->play->loop->isRunning->AUDIOTHREAD | play ->isRunning->AUDIOTHREAD).*/


public class AudioThread extends Thread{

	private volatile boolean isRunning = false;
	public Clip clip;
	private final String musicBack = ".//res//pacman_beginning.wav";
	public String filename;
	private boolean isMusic = false;
	private int volM=0;
	private int volS=0;
	private boolean bPaused = false;
	private boolean muteo = false;

	public AudioThread(String filename) {
		super();
		this.filename = filename;
	}

	public AudioThread() {
		super();
	}

	@Override
	public void run() {
		isRunning = true;
		this.setFile(filename);


		while(isRunning) {

			if(muteo) {
				//this.setVol(0);
				this.setVolume(0);
			}

			else if(!muteo){

				if(isMusic) {
					volM = Input.count;
					this.setVolume(volM);
					try {
						this.play();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					this.loop();

				}
				else if(!isMusic){
					volS= Input.countS;
					this.setVolume(volS);
					try {
						this.play();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//this.stopAudioThread();
				}

			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public synchronized void setFile(String soundFileName) {
		try {
			File file = new File(soundFileName);
			AudioInputStream sound = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(sound);
		}
		catch(Exception e) {

		}
	}

	public synchronized void play() throws InterruptedException {
		clip.setFramePosition(0);
		clip.start();
		Thread.sleep(50);// given clip.drain a chance to start
		clip.drain();
	}

	public synchronized void loop() {
		clip.loop(clip.LOOP_CONTINUOUSLY);
	}

	public void stopAudioThread() {
		isRunning=false;
		clip.stop();
		clip.close();
	}

	public synchronized boolean isPaused()
	{
		return bPaused;
	}

	public synchronized void Pause()
	{
		bPaused = true;
	}

	public synchronized void Resume()
	{
		bPaused = false;
	}
	

	public void setMute(boolean mute) {
		BooleanControl bc = (BooleanControl)clip.getControl(BooleanControl.Type.MUTE);
		if (bc != null) {
			bc.setValue(mute);
		}
	}

	public void setVolume(int volume) {
		if (volume == 0) {
			setMute(true);
		} else {
			setMute(false);
			FloatControl fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
			if (fc != null) {
				fc.setValue(computeGain(fc, volume));
			}
		}
	}

	public static float computeGain(FloatControl fc, int volume) {
		float min = Math.max(fc.getMinimum(), -43);
		float max = Math.min(fc.getMaximum(), 0);
		return min + (max - min) * volume / 100;
	}

	public synchronized boolean isMusic() {
		return isMusic;
	}

	public synchronized void setMusic(boolean isMusic) {
		this.isMusic = isMusic;
	}

	public synchronized int getVolM() {
		return volM;
	}

	public synchronized void setVolM(int vol) {
		this.volM = vol;
	}

	public synchronized boolean isMuteo() {
		return muteo;
	}

	public synchronized void setMuteo(boolean muteo) {
		this.muteo = muteo;
	}

	public synchronized int getVolS() {
		return volS;
	}

	public synchronized void setVolS(int volS) {
		this.volS = volS;
	}
	

}