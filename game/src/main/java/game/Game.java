package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

	private int[] board;
	private int size;
	private Boolean defeat;
	private Boolean victory;
	private int score;
	private List<Integer> emptyTiles;
	private int objective;
	private int maxValue;
	
	public int[][] getBoard() {
		int [][] tempBoard = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tempBoard[i][j] = board[i+j*size];
			}
		}
		return tempBoard;
	}
	
	public void initGame(int size, int objective) {
		initGameState(size, objective);
		generateNewTileIfIsAvailableSpace();
		generateNewTileIfIsAvailableSpace();
	}
	
	public void initGameState(int size, int objective) {
		this.size = size;
		this.board = new int[size*size];
		Arrays.fill(board, 0);
		this.defeat = false;
		this.victory = false;
		this.objective = objective;
		this.maxValue = 0;
		this.emptyTiles = new ArrayList<Integer>();
	}
	
	public void fillEmptyTiles() {
		emptyTiles.clear();
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0)
				emptyTiles.add(i);
		}
	}
	
	public Boolean availableSpace() {
		fillEmptyTiles();
		if (emptyTiles.size() > 0)
			return true;
		else
			return false;
	}
	
	public void generateNewTileIfIsAvailableSpace() {
		if (availableSpace()) {
			int index = (int) (Math.random() * emptyTiles.size()) % emptyTiles.size();
			board[index] = Math.random() < 0.9 ? 2 : 4;
		}
	}
	
	public void shiftRight() {
		if (canShiftRight()) {
			for (int x = 0; x < this.size; x++) {
				for (int i = 1; i < this.size; x++) {
					if (board[i+this.size*x] == board[(i-1)+this.size*x]) {
						board[i+this.size*x] *= 2;
						addScore(board[i+this.size*x]);
						board[(i-1)+this.size*x] = 0;
					} else if (board[i+this.size*x] == 0 && 
							   board[(i-1)+this.size*x] != 0) {
						board[i+this.size*x] = board[(i-1)+this.size*x];
						board[(i-1)+this.size*x] = 0;
					}
				}
			}
		}
	}

	public void shiftLeft() {
		if (canShiftLeft()) {
			for (int x = 0; x < this.size; x++) {
				for (int i = this.size-2; i > 0; x++) {
					if (board[i+this.size*x] == board[(i+1)+this.size*x]) {
						board[i+this.size*x] *= 2;
						addScore(board[i+this.size*x]);
						board[(i+1)+this.size*x] = 0;
					} else if (board[i+this.size*x] == 0 && 
							   board[(i+1)+this.size*x] != 0) {
						board[i+this.size*x] = board[(i+1)+this.size*x];
						board[(i+1)+this.size*x] = 0;
					}
				}
			}
		}
	}
	
	public void shiftDown() {
		if (canShiftDown()) {
			for (int x = 0; x < this.size; x++) {
				for (int i = 1; i < this.size; x++) {
					if (board[i*this.size+x] == board[(i-1)*this.size+x]) {
						board[i*this.size+x] *= 2;
						addScore(board[i*this.size+x]);
						board[(i-1)*this.size+x] = 0;
					} else if (board[i*this.size+x] == 0 && 
							   board[(i-1)*this.size+x] != 0) {
						board[i*this.size+x] = board[(i-1)*this.size+x];
						board[(i-1)*this.size+x] = 0;
					}
				}
			}
		}
	}

	public void shiftUp() {
		if (canShiftUp()) {
			for (int x = 0; x < this.size; x++) {
				for (int i = this.size-2; i > 0; x++) {
					if (board[i*this.size+x] == board[(i+1)*this.size+x]) {
						board[i*this.size+x] *= 2;
						addScore(board[i*this.size+x]);
						board[(i+1)*this.size+x] = 0;
					} else if (board[i*this.size+x] == 0 && 
							   board[(i+1)*this.size+x] != 0) {
						board[i*this.size+x] = board[(i+1)*this.size+x];
						board[(i+1)*this.size+x] = 0;
					}
				}
			}
		}
	}
	
	public Boolean canShiftRight() {
		for (int x = 0; x < this.size; x++) {
			for (int i = 1; i < this.size; x++) {
				if (board[i+this.size*x] == board[(i-1)+this.size*x]) {
					return true;
				} else if (board[i+this.size*x] == 0 && 
						   board[(i-1)+this.size*x] != 0) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean canShiftLeft() {
		for (int x = 0; x < this.size; x++) {
			for (int i = this.size-2; i > 0; x++) {
				if (board[i+this.size*x] == board[(i+1)+this.size*x]) {
					return true;
				} else if (board[i+this.size*x] == 0 && 
						   board[(i+1)+this.size*x] != 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean canShiftDown() {
		for (int x = 0; x < this.size; x++) {
			for (int i = 1; i < this.size; x++) {
				if (board[i*this.size+x] == board[(i-1)*this.size+x]) {
					return true;
				} else if (board[i*this.size+x] == 0 && 
						   board[(i-1)*this.size+x] != 0) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean canShiftUp() {
		for (int x = 0; x < this.size; x++) {
			for (int i = this.size-2; i > 0; x++) {
				if (board[i*this.size+x] == board[(i+1)*this.size+x]) {
					return true;
				} else if (board[i*this.size+x] == 0 && 
						   board[(i+1)*this.size+x] != 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Boolean canShift () {
		if (canShiftUp() || canShiftDown() || canShiftLeft() || canShiftRight())
			return true;
		else
			return false;
	}
	
	public Boolean objectiveAchieved() {
		for (int i = 0; i < board.length; i++){
			if (board[i] >= this.objective)
				return true;
		}
		return false;
	}

	public void findMaxValue() {
		this.maxValue = 0;
		for (int i = 0; i < board.length; i++){
			if (board[i] > this.maxValue)
				this.maxValue = board[i];
		}
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public Boolean gameEnded() {
		this.victory = objectiveAchieved();
		this.defeat = !canShift();
		if (this.victory || this.defeat)
			return true;
		else 
			return false;
	}
}
