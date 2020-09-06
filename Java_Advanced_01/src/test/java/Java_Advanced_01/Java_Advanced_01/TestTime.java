package Java_Advanced_01.Java_Advanced_01;


import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.TestWatcher;

public class TestTime {
	
	
	
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
		
	}
	
	@After
	public void afterTest() {
		
	}
	
	
	@Test
	public void addTimeTest() {
		
		Time realValue = new Time(1, 10);
		realValue = realValue.addTime(new Time(1, 10));
		
		Time expectedValue = new Time(2, 20);

		
		assertEquals(realValue, expectedValue);
	}
	
	

	

}
