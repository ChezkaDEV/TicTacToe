/* Has menus, score tracking, name adding, reset features, mnemonic parsing, and keyboard shortcuts */
package tictactoe;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TicTacToeGame extends BorderPane {
	private StringProperty xPlayer = new SimpleStringProperty("X player");
	private StringProperty oPlayer = new SimpleStringProperty("O player");
	private Player currentPlayer = Player.X;
	private TicTacToeBoard board;

	TicTacToeGame(Stage stage) {
		board = new TicTacToeBoard(this);
		setCenter(board);
	}

	// what the prompts will say when or if the game ends
	public void endPrompt(String message) {
		//disables board
		board.disable();
	
		Stage stage = new Stage();
		Label label = new Label(message);
		label.setStyle("-fx-font-weight: bold;");

		final int BUTTON_WIDTH = 80;

		Button reset = new Button("New Round");
		reset.setMinWidth(BUTTON_WIDTH);
		reset.setOnAction(e -> {
			stage.close();
			newRound();
		});
		
		reset.setDefaultButton(true);

		Button quit = new Button("Quit");
		quit.setMinWidth(BUTTON_WIDTH);
		quit.setOnAction(e -> Platform.exit());

		HBox gameLayout = new HBox(5);
		gameLayout.getChildren().addAll(reset, quit);
		gameLayout.setAlignment(Pos.CENTER);

		VBox layout = new VBox(5);
		layout.getChildren().addAll(label, gameLayout);
		layout.setAlignment(Pos.CENTER);

		// sets the width and length of the game over end prompt
		stage.setScene(new Scene(layout, 175 + new Text(message).getLayoutBounds().getWidth(), 75));
		stage.sizeToScene();
		stage.setTitle("Game Over");
		stage.show();
	}

	// current player
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	// new round button
	private void newRound() {
		board.boardCounter = 0;
		board.reset();
	}
	
	// checks to see who has 3 in a row
	public String checkWinner(String winner) {
		if (winner.equals("X")) {
			return xPlayer.getValue();
		} else {
			return oPlayer.getValue();
		}
	}

	// deciding factor of when to know when its your turn or not
	public void endTurn() {
		currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
	}
}