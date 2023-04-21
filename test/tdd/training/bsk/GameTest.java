package tdd.training.bsk;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void addAnewFrameInAGame() throws BowlingException {
		Game game = new Game();
		game.addFrame(new Frame(9, 0));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(0, 2));
		
		assertEquals(0 , game.getFrameAt(3).getFirstThrow());
		assertEquals(2 , game.getFrameAt(3).getSecondThrow());
	}
	
	@Test(expected = BowlingException.class)
	public void addElevenFrameGame() throws BowlingException {
		Game game = new Game();
		game.addFrame(new Frame(9, 0));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(0, 2));
	}
	
	@Test(expected = BowlingException.class)
	public void getInvalidFrameGame() throws BowlingException {
		Game game = new Game();
		game.addFrame(new Frame(9, 0));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(0, 2));
		
		game.getFrameAt(4);
	}
	
	@Test
	public void calculateGameScore() throws BowlingException {
		Game game = new Game();
		game.addFrame(new Frame(9, 0));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(5, 2));
		game.addFrame(new Frame(8, 2));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(5, 5));
		game.addFrame(new Frame(7, 3));
		game.addFrame(new Frame(6, 4));
		game.addFrame(new Frame(9, 0));
		
		assertEquals(72, game.calculateScore());
	}
	
	@Test(expected = BowlingException.class)
	public void getInvalidScoreFrameGame() throws BowlingException {
		Game game = new Game();
		game.addFrame(new Frame(9, 4));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(0, 2));
		
		game.calculateScore();
	}

}
