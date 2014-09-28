package bet;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import sport.GameNotPlayedException;
import sport.item.Game;

import bet.bookie.Bookie;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Odds {
	private Game game;
	private Bookie bookie;
	
	public Odds() {
		
	}

	@ManyToOne
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}

	public Bookie getBookie() {
		return bookie;
	}
	public void setBookie(Bookie bookie) {
		this.bookie = bookie;
	}

	
}
