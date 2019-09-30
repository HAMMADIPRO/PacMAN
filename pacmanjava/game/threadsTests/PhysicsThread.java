
package threadsTests;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;







class PhysicsThread {
	Threads.PhysicsThread ft;

	@BeforeEach
	public void setUp() {
		
		ft= new Threads.PhysicsThread();
		assertNotNull(ft);
		ft.start();
	
		assertTrue(ft.isAlive(), "Thread init faild");
		
	}
	

	
	
	@AfterEach
	public void tearDown() {
		
		synchronized (ft) {
			
			try {ft.stopThread();
			ft.join();
			if(ft.isAlive()) {
				ft.interrupt();
			}
			
			assertFalse(ft.isAlive(),"thread should be stopped ");
			
			}catch(Exception e) {}
			
		}
		
	}
	
	@Test
	void test() {
		
		
	
	}
	

}
