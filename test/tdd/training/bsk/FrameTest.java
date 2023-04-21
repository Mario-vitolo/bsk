package tdd.training.bsk;

import static org.junit.Assert.*;

import org.junit.Test;


public class FrameTest {

	@Test
	public void getFirstThrow() throws Exception{
		Frame frame = new Frame(10, 0);
		assertEquals(10, frame.getFirstThrow());
	}
	
	@Test
	public void getSecondThrow() throws Exception{
		Frame frame = new Frame(0, 10);
		assertEquals(10, frame.getSecondThrow());
	}
	
	@Test
	public void calculateFrameScore() throws Exception{
		Frame frame = new Frame(5, 10);
		assertEquals(15, frame.getScore());
	}

}
