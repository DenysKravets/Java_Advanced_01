package Java_Advanced_01.Java_Advanced_01;


import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.TestWatcher;

public class TestStart {
	
	private Start start;
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("Failed, " + description.getMethodName());
		};
		
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("Succeed, " + description.getMethodName());
		};
	};
	
	@Before
	public void beforeTest() {
		start = new Start();
	}
	
	@After
	public void afterTest() {
		start = null;
	}
	
	
	@Test
	public void returnOneTest() {
		assertEquals(1, start.returnOne());
	}
	
	

	

}
