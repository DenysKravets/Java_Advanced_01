package Java_Advanced_01.Java_Advanced_01;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TestCinema {
	
		//Test object
		private Cinema cinema;
		
		//Dummy objects for testing
		private Schedule schedule;
		private Seance seance;
		private Movie movie;
		private Time time;
		private String dayOfTheWeek;
		
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
			cinema = new Cinema();
			//Dummy objects
			dayOfTheWeek = "MONDAY";
			time = new Time(1, 20);
			movie = new Movie("Selamat pagi", time);
			seance = new Seance(movie, time);
			schedule = new Schedule();
			schedule.addSeance(seance);
			
		}
		
		//Deleting these objects after each test
		@After
		public void afterTest() {
			//Test object
			cinema = null;
			//Dummy objects
			dayOfTheWeek = null;
			time = null;
			movie = null;
			seance = null;
			schedule = null;
		}
		
		@Test
		public void addMovieTest() {
			cinema.addMovie(movie);
			assertTrue(cinema.movieLibrary.contains(movie));	
		}
		
		@Test
		public void addSceance() {
			cinema.addSceance(seance, dayOfTheWeek);
			
			Iterator<Entry<Days, Schedule>> interator1 = cinema.schedules.entrySet().iterator();
			while(interator1.hasNext())
			{
				Entry<Days, Schedule> entry = interator1.next();
				
				if(entry.getKey().name().equals(dayOfTheWeek)) {
					assertTrue(entry.getValue().getSeances().contains(seance));
				}
			}
		}
		
		@Test
		public void removeMovie() {
			cinema.addSceance(seance, dayOfTheWeek);
			cinema.removeMovie(movie);
			
			Iterator<Entry<Days, Schedule>> interator1 = cinema.schedules.entrySet().iterator();
			while(interator1.hasNext())
			{
				Entry<Days, Schedule> entry = interator1.next();
				
				Iterator<Seance> iterator2 = entry.getValue().getSeances().iterator();
				while(iterator2.hasNext())
				{
					Seance innerSeance = iterator2.next();
					
					if(innerSeance.getMovie().equals(movie))
					{
						assertTrue(false);
					}
				}
			}
		}
		
		@Test
		public void removeSeance() {
			cinema.addSceance(seance, dayOfTheWeek);
			cinema.removeSeance(seance, dayOfTheWeek);
			
			Iterator<Entry<Days, Schedule>> interator1 = cinema.schedules.entrySet().iterator();
			while(interator1.hasNext())
			{
				Entry<Days, Schedule> entry = interator1.next();
				
				if(entry.getKey().name().equals(dayOfTheWeek)) {
					assertFalse(entry.getValue().getSeances().contains(seance));
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
}
