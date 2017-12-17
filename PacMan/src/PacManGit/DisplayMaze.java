package PacManGit;

public class DisplayMaze {

	public static void main(String[] args) {
		MazeGenerator x = new MazeGenerator();
		x.generate(28, 28);
		System.out.println();
		x.showBorderedMaze();
	}

}
