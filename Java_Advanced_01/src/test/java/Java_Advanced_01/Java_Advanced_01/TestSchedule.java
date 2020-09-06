package Java_Advanced_01.Java_Advanced_01;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TestSchedule {
	
	//Test object
	private Schedule schedule;
	
	//Dummy objects for testing
	private Seance seance;
	private Movie movie;
	private Time time;
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("Failed, " + description.getMethodName());
		};
		
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("Succeed, " + description.getMethodName());
		};
	};
	
	//Creating test and dummy object before every test
	@Before
	public void beforeTest() {
		//Test object
		schedule = new Schedule();
		//Dummy objects
		time = new Time(1, 20);
		movie = new Movie("Selamat pagi", time);
		seance = new Seance(movie, time);
	}
	
	//Deleting these objects after each test
	@After
	public void afterTest() {
		//Test object
		schedule = null;
		//Dummy objects
		time = null;
		movie = null;
		seance = null;
	}
	
	
	@Test
	public void addSeanceTest() {
		schedule.addSeance(seance);
		assertTrue(schedule.getSeances().contains(seance));
	}
	
	@Test
	public void removeSeanceTest() {
		schedule.addSeance(seance);
		schedule.removeSeance(seance);
		assertFalse(schedule.getSeances().contains(seance));
	}
	
	
}
