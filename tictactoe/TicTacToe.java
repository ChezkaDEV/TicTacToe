package tictactoe;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class TicTacToe extends Application {
	public static void main(String[] args) {
		//launches GUI
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Tic Tac Toe By Chezka");
		stage.setScene(new Scene(new TicTacToeGame(stage)));
		stage.show();
	}
}