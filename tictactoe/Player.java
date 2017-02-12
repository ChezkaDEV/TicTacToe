package tictactoe;

public enum Player {
	X("-fx-text-fill: darkred;"),
	O("-fx-text-fill: darkblue;");

	private final String style;

	Player(String style) {
		this.style = style;
	}

	public String getStyle() {
		return style;
	}
}