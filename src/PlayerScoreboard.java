import java.util.Arrays;

public class PlayerScoreboard {
	private int[][] board;
	private int pointCounter;
	
	public PlayerScoreboard() {
		this.board = new int[4][4];
		this.pointCounter = 1;
	}
	
	public void addTile(int row, int col) {
		board[row][col] = 1;
	}
	
	public int addPoints(int row, int col) {
		int counter = pointCounter;
		for (int i = 4; i >= 0; i--) {
			if (isInBounds(row, col - 1)) {
				if (board[row][col - 1] == 1) {
					pointCounter++;
					addPoints(row, col - 1);
				}
			}
			if (isInBounds(row, col + 1)) {
				if (board[row][col + 1] == 1) {
					pointCounter++;
					addPoints(row, col + 1);
				}
			}
			if (isInBounds(row - 1, col)) {
				if (board[row - 1][col] == 1) {
					pointCounter++;
					addPoints(row - 1, col);
				}
			}
			if (isInBounds(row + 1, col)) {
				if (board[row + 1][col] == 1) {
					pointCounter++;
					addPoints(row + 1, col);
				}
			}
		}
		pointCounter = 1;
		return counter;
	}
	
	public boolean isInBounds(int row, int col) {
		int[] bounds = {row, col};
		boolean upperBoundCheck = Arrays.stream(bounds).allMatch(x -> x < board.length);
		boolean lowerBoundCheck = Arrays.stream(bounds).allMatch(x -> x > 0);
		if (upperBoundCheck && lowerBoundCheck) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfRowComplete(int row) {
		int[] columns = {board[row][0], board[row][1], board[row][2], board[row][3], board[row][4]};
		boolean check = Arrays.stream(columns).allMatch(x -> x == 1);
		if (check) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfColumnComplete(int col) {
		int[] rows = {board[0][col], board[1][col], board[2][col], board[3][col], board[4][col]};
		boolean check = Arrays.stream(rows).allMatch(x -> x == 1);
		if (check) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfBlackComplete() {
		int[] blackTiles = {board[0][3], board[1][4], board[2][0], board[3][1], board[4][2]};
		boolean check = Arrays.stream(blackTiles).allMatch(x -> x == 1);
		if (check) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfBlueComplete() {
		int[] blackTiles = {board[0][0], board[1][1], board[2][2], board[3][3], board[4][4]};
		boolean check = Arrays.stream(blackTiles).allMatch(x -> x == 1);
		if (check) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfRedComplete() {
		int[] blackTiles = {board[0][2], board[1][3], board[2][4], board[3][0], board[4][1]};
		boolean check = Arrays.stream(blackTiles).allMatch(x -> x == 1);
		if (check) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfWhiteComplete() {
		int[] blackTiles = {board[0][4], board[1][0], board[2][1], board[3][2], board[4][3]};
		boolean check = Arrays.stream(blackTiles).allMatch(x -> x == 1);
		if (check) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfYellowComplete() {
		int[] blackTiles = {board[0][1], board[1][2], board[2][3], board[3][4], board[4][0]};
		boolean check = Arrays.stream(blackTiles).allMatch(x -> x == 1);
		if (check) {
			return true;
		}
		return false;
	}
	
	public int addBonusPoints() {
		int points = 0;
		for (int i = 4; i >= 0; i--) {
			if (checkIfRowComplete(i)) {
				points += 2;
			}
			if (checkIfColumnComplete(i)) {
				points += 7;
			}
		}
		if (checkIfBlackComplete()) {
			points += 10;
		}
		if (checkIfBlueComplete()) {
			points += 10;
		}
		if (checkIfRedComplete()) {
			points += 10;
		}
		if (checkIfWhiteComplete()) {
			points += 10;
		}
		if (checkIfYellowComplete()) {
			points += 10;
		}
		return points;
	}

}
