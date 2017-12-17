package PacManGit;

import Objects.Interactables;

public class FlyWeight {
	private Interactables[][] charMaze;
	private MazeGenerator getMaze = new MazeGenerator();
	private ConvertIterator converter = new ConvertIterator();
	
	public FlyWeight() {
	}

	public Interactables[][] getCharMaze() {
		if(charMaze == null) {
			charMaze = converter.convert(getMaze.generate(30, 30));
		}
		return charMaze;
	}
	public void  setCharMaze(Interactables[][] x) {
		charMaze=x;
	}

	public MazeGenerator getMazeGenerator() {
		return getMaze;
	}
	
	
}
