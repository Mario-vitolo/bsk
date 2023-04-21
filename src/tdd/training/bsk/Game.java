package tdd.training.bsk;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private List<Frame> frames;

	/**
	 * It initializes an empty bowling game.
	 */
	public Game() {
		frames = new ArrayList<Frame>();
	}

	/**
	 * It adds a frame to this game.
	 * 
	 * @param frame The frame.
	 * @throws BowlingException
	 */
	public void addFrame(Frame frame) throws BowlingException {
		if(frames.size() == 10) {
			throw new BowlingException("More than 10 Frames");
		}
		frames.add(frame);
	}

	/**
	 * It return the i-th frame of this game.
	 * 
	 * @param index The index (ranging from 0 to 9) of the frame.
	 * @return The i-th frame.
	 * @throws BowlingException
	 */
	public Frame getFrameAt(int index) throws BowlingException {
		if(index < 1 || index >10 || index > frames.size())
			throw new BowlingException("Invalid Frame");
		return frames.get(index-1);
		
			
	}

	/**
	 * It sets the first bonus throw of this game.
	 * 
	 * @param firstBonusThrow The first bonus throw.
	 * @throws BowlingException
	 */
	public void setFirstBonusThrow(int firstBonusThrow) throws BowlingException {
		// To be implemented
	}

	/**
	 * It sets the second bonus throw of this game.
	 * 
	 * @param secondBonusThrow The second bonus throw.
	 * @throws BowlingException
	 */
	public void setSecondBonusThrow(int secondBonusThrow) throws BowlingException {
		// To be implemented
	}

	/**
	 * It returns the first bonus throw of this game.
	 * 
	 * @return The first bonus throw.
	 */
	public int getFirstBonusThrow() {
		// To be implemented
		return 0;
	}

	/**
	 * It returns the second bonus throw of this game.
	 * 
	 * @return The second bonus throw.
	 */
	public int getSecondBonusThrow() {
		// To be implemented
		return 0;
	}

	/**
	 * It returns the score of this game.
	 * 
	 * @return The score of this game.
	 * @throws BowlingException
	 */
	public int calculateScore() throws BowlingException {
		int score = 0; 
		for( int i =0; i < frames.size(); i++) {
			//Spare
			if(frames.get(i).isSpare() && i< frames.size()-1) {
				frames.get(i).setBonus(frames.get(i+1).getFirstThrow());
			}
			//Strike
			if(frames.get(i).isStrike()) {
				if(frames.get(i+1).isStrike()) {
					frames.get(i).setBonus(frames.get(i+1).getScore() + frames.get(i+2).getFirstThrow());	
				}else {
				frames.get(i).setBonus(frames.get(i+1).getScore());
				}
			}
			int frameScore = frames.get(i).getScore() + frames.get(i).getBonus();
			if(frameScore < 0) {
				throw new BowlingException("Invalid Score");
			}
			score += frameScore;
		}
		return score;	
	}

}
