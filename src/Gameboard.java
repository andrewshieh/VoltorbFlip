/**
 * Gameboard.java
 * for GunnHacks 3.0
 * @author andrewshieh
* */
public class Gameboard {

	private int[][] board;
	private boolean[][] flipped;
	private int score;
	
	/*
	 * creates a new 5x5 unflipped gameboard
	 */
	public Gameboard() {
		board = new int[5][5];
		flipped = new boolean[5][5];
		score = 1;
	}
	
	/**
	 * resets the gameboard
	 */
	public void resetGame() {
		fillGameboard();
		//sets all tiles to unflipped
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				flipped[i][j] = false;
			}
		}
		//initializes score to 1
		score = 1;
	}
	
	/**
	 * fills the gameboard with tiles
	 */
	public void fillGameboard() {
		//populates the board with ones
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = 1;
			}
		}
		//adds 6 bombs/voltorbs
		for (int i = 0; i < 6; i++) {
			int x, y;
			do {
				x = (int)(Math.random()*5);  
				y = (int)(Math.random()*5);
			} while (board[x][y] == 0);
			board[x][y] = 0; //checks to see if the tile is occupied
		}
		//adds 2 twos
		for (int i = 0; i < 2; i++) {
			int x, y;
			do {
				x = (int)(Math.random()*5);
				y = (int)(Math.random()*5);
			} while (board[x][y] == 0 || board[x][y] == 2); //checks to see if the tile is occupied
			board[x][y] = 2;
		}
		//adds 2 threes
		for (int i = 0; i < 2; i++) {
			int x, y;
			do {
				x = (int)(Math.random()*5);
				y = (int)(Math.random()*5);
			} while (board[x][y] == 0 || board[x][y] == 2 || board[x][y] == 3); //checks to see if the tile is occupied
			board[x][y] = 3;
		}
	}
	
	/**
	 * returns the value at (x,y)
	 * @param x x
	 * @param y y
	 * @return 0, 1, 2, 3 depending on the value
	 */
	public int getBoxValue(int x, int y) {
		return board[x][y];
	}
	
	/**
	 * returns true if the tile at (x,y) is flipped, false if not
	 * @param x x
	 * @param y y
	 * @return true or false depending on the value
	 */
	public boolean isBoxFlipped(int x, int y) {
		return flipped[x][y];
	}
	
	/**
	 * flips the tile at (x,y)
	 * @param x x
	 * @param y y
	 */
	public void flip(int x, int y) {
		if (!flipped[x][y]) {
			flipped[x][y] = true;
			score *= board[x][y];
		}
	}
	
	/**
	 * returns the score
	 * @return score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * checks if the game is over
	 * @return true if the game is over, false if not
	 */
	public boolean isOver() {
		return score == 0 || score == 36;
	}
	
	/**
	 * checks if the game has been won
	 * @return true if the game has been won, false if not
	 */
	public boolean isWon() {
		return score == 36;
	}
		
	/**
	 * calculates sum of tiles in a certain row
	 * @param row row
	 * @return sum of tiles in that row
	 */
	public int sumArrayRow(int row) {
		int sum = 0;
		for (int i = 0; i < board[row].length; i++) {
			sum += board[row][i];
		}
		return sum;
	}
	
	/**
	 * calculates sum of tiles in a certain column
	 * @param column column
	 * @return sum of tiles in that column
	 */
	public int sumArrayColumn(int column) {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			sum += board[i][column];
		}
		return sum;
	}
	
	/**
	 * calculates number of bombs in a certain row
	 * @param row row
	 * @return number of bombs in that row
	 */
	public int bombsArrayRow(int row) {
		int sum = 0;
		for (int i = 0; i < board[row].length; i++) {
			if (board[row][i] == 0) sum++;
		}
		return sum;
	}
	
	/**
	 * calculates number of bombs in a certain column
	 * @param column column
	 * @return number of bombs in that column
	 */
	public int bombsArrayColumn(int column) {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][column] == 0) sum++;
		}
		return sum;
	}
	
}
