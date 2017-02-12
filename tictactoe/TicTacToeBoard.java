/* Board class to represent idea of tic tac toe board */
package tictactoe;
import javafx.scene.layout.GridPane;

public class TicTacToeBoard extends GridPane {
	private final int NUMBER_OF_SQUARES = 16;
	public int boardCounter;
	private TicTacToeSquare[] board = new TicTacToeSquare[NUMBER_OF_SQUARES];
	private TicTacToeGame game;

	TicTacToeBoard(TicTacToeGame game) {
		this.game = game;

		// Creates buttons as a grid
		for (int i = 0; i < board.length; i++) {
			board[i] = new TicTacToeSquare(game, this);
			add(board[i].button(), i / 4, i % 4);
		}
	}

	/*
	 * 				0 4 8 12
	 * 				1 5 9 13
	 * 				2 6 10 14
	 * 				3 7 11 15
	 * */
	
	public void evaluateState() {
		for (int i = 0, j = 0; i < 4; i++) {
			// Horizontal
			if(checkSet(j++, j++, j++)) { return; }
			
			// Vertical
			if(checkSet(i, i + 4, i + 8)) {	return; }	
		}
		
		//top left, top middle, bottom right
		if(checkSet(0, 3, 8)) { return; }
		
		
		// Diagonal
		if(checkSet(0, 4, 8) || checkSet(2, 4, 6)) { return; }

		if (++boardCounter == NUMBER_OF_SQUARES) {
			game.endPrompt("It's a tie!");
			return;
		}
	}
	
	// three in a row, checking it see if player wins
	private boolean checkSet(int square1, int square2, int square3) {
		if (boardCounter >= 4) {
			if (board[square1].equivalentTo(board[square2]) 
			&& board[square2].equivalentTo(board[square3])) {
				game.endPrompt(game.checkWinner(board[square1].button().getText()) + " wins!");
				return true;
			}
		}
		return false;
	}

	// For when you want to quit the game, disables GUI
	public void disable() {
		for (int i = 0; i < board.length; i++) {
			board[i].button().setDisable(true);
		}
	}

	// For when you want to reset the game after the game ends
	// creates new game
	public void reset() {
		for (int i = 0; i < board.length; i++) {
			board[i].reset();
		}
	}
}