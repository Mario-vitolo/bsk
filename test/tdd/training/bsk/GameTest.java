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
		game.addFrame(new Frame(8, 1));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(5, 4));
		game.addFrame(new Frame(7, 2));
		game.addFrame(new Frame(6, 3));
		game.addFrame(new Frame(9, 0));
		
		assertEquals(68, game.calculateScore());
	}
	
	@Test(expected = BowlingException.class)
	public void getInvalidScoreFrameGame() throws BowlingException {
		Game game = new Game();
		game.addFrame(new Frame(0, -1));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(0, 2));
		
		game.calculateScore();
	}
	
	@Test
	public void calculateScoreGameWithSpareBonus() throws BowlingException {
		Game game = new Game();
		game.addFrame(new Frame(9, 0));
		game.addFrame(new Frame(5, 0));
		game.addFrame(new Frame(0, 2));
		game.addFrame(new Frame(5, 2));
		game.addFrame(new Frame(8, 2));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(1, 5));
		game.addFrame(new Frame(1, 3));
		game.addFrame(new Frame(1, 4));
		game.addFrame(new Frame(9, 0));
		
		assertEquals(57, game.calculateScore());
	}
	
	@Test
	public void calculateScoreGameWithStrikeBonus() throws BowlingException {
		Game game = new Game();
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(10, 0));
		game.addFrame(new Frame(1, 0));
		game.addFrame(new Frame(1, 0));
		game.addFrame(new Frame(0, 0));
		game.addFrame(new Frame(0, 0));
		
		assertEquals(14, game.calculateScore());
	}

}
