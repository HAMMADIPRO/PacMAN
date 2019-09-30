
package threadsTests;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.channels.InterruptedByTimeoutException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AudioThread {

	private static Threads.AudioThread audio;
	private static int JOIN_TIMER = 500;



	@BeforeEach
	public void setUp() throws Exception 
	{
		
		
	    audio = new Threads.AudioThread();
		assertNotNull(audio, "Thread init failed");		
		
		
		audio.start();
		assertTrue(audio.isAlive(), "Thread should be started");
	}

	@AfterEach
	public void tearDown() throws Exception 
	{
		synchronized(audio)
		{
			try 
			{		
				audio.stopAudioThread();
				audio.join(JOIN_TIMER);
				if (audio.isAlive())
				{
					audio.interrupt();
					throw new InterruptedByTimeoutException();
				}
				
			} 
			catch (InterruptedException | InterruptedByTimeoutException e) 
			{
				assertEquals(null, e, "Throw exception occurred");
			}
			
			assertFalse(audio.isAlive(), "Thread should be stopped");
		
		}
	}
	
	@Test
	public void testStopAudioThread() {

		audio.stopAudioThread();

			assertFalse(audio.isAlive(), "Thread should be stopped");
			assertFalse(audio.clip.isRunning(), "Tclip should be stopped");
			assertFalse(audio.clip.isOpen(), "Thread should be closed");
	

	}

	

	@Test
	public void testPause() {

		audio.Pause();
		assertTrue(audio.isPaused(), "Thread should be paused");
		

	}
	@Test
	public void testResume(){
	    audio.Resume();
		assertFalse(audio.isPaused(), "Thread should be resumed");
	}


	@Test
	public void testisMusic() {

		audio.setMusic(true);
		assertEquals(audio.isMusic(),true);
		audio.setMusic(false);
		assertEquals(audio.isMusic(),false);	
	}
	@Test
	public void testisMuteo() {

		audio.setMuteo(true);
		assertEquals(audio.isMuteo(),true);
		audio.setMuteo(false);
		assertEquals(audio.isMuteo(),false);
		
}
	


	
	
	


}



