package sport;

import sport.item.Game;


public class GameNotPlayedException extends Throwable {

	private static final long serialVersionUID = 3705019257944848983L;
	private Game game;
	
	public GameNotPlayedException(Game game) {
		super();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	
	@Override
	public String getMessage() {
		return "Game not played: " + game;
	}
}
