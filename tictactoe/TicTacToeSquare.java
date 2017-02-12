/* Object to represent idea of tic tac toe squares */
package tictactoe;
import javafx.scene.control.Button;

public class TicTacToeSquare {
	private Button button = new Button();
	private final int SQUARE_LENGTH = 100;

	TicTacToeSquare(TicTacToeGame game, TicTacToeBoard board) {
		button.setMinSize(SQUARE_LENGTH, SQUARE_LENGTH); // 100x100
		button.setOnAction(e -> {
			if (button.getText().isEmpty()) {
				//get current player and style
				button.setText(game.getCurrentPlayer().toString());
				button.setStyle(game.getCurrentPlayer().getStyle());
				//evaluates scores
				board.evaluateState();
				game.endTurn();
			}
		});
	}

	public Button button() {
		return button;
	}

	public boolean equivalentTo(TicTacToeSquare target) {
		// if the button is empty and if the button text equals to button 
		// text we are targetting at, which checkSet is using in tictactoeBoard
		return !button.getText().isEmpty() && button.getText().equals(target.button().getText());
	}

	public void reset() {
		button.setText("");
		button.setDisable(false);
	}
}