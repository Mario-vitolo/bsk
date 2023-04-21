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
	
	@Test
	public void isSpare() throws BowlingException {
		Frame frame = new Frame(9, 1);
		assertTrue(frame.isSpare());
	}
	
	@Test
	public void getBonusFrame() throws BowlingException {
		Frame frame = new Frame(9, 1);
		frame.setBonus(2);
		assertEquals(2, frame.getBonus());
	}
	
	@Test
	public void calculateScoreFrameWithSpareBonus() throws BowlingException {
		Frame frame = new Frame(9, 1);
		frame.setBonus(2);
		assertEquals(12, frame.getScore());
	}
	
	@Test
	public void isStrike() throws BowlingException {
		Frame frame = new Frame(10, 0);
		
		assertTrue(frame.isStrike());
	}
	
	@Test
	public void calculateScoreFrameWithStrikeBonus() throws BowlingException {
		Frame frame = new Frame(10,0);
		frame.setBonus(20);
		assertEquals(30, frame.getScore());
	}
}
