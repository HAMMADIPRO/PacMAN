
package threadsTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class RenderThread {

	Threads.RenderThread rt;
	
	@BeforeEach
	public void setUp() {
		
		assertNotNull(rt);
		
		rt.start();
		
	}
	

	@AfterEach
	public void tearDown() {
		
		synchronized (rt) {
			
			try {rt.stopThread();
					
			
			}catch(Exception e) {}
			
		}
		
	}
	
	
	@Test
	void test() {
		
		
	
	}


}
