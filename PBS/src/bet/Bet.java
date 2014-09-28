package bet;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Entity;

import bet.bookie.Bookie;

import sport.GameNotPlayedException;
import sport.item.Game;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Bet {
	private int id;
	private Game game;
	private double amount;
	private double coefficient;
	private Bookie bookie;
	
	public Bet() {
		
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = Math.max(0.0, amount);
	}

	@ManyToOne
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	
	@ManyToOne
	public Bookie getBookie() {
		return bookie;
	}
	public void setBookie(Bookie bookie) {
		this.bookie = bookie;
	}
	
	public double getCoefficient() {
		return this.coefficient;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	

	public double getReturn() throws GameNotPlayedException {
		if (this.isCorrect()) {
			return coefficient * amount;
		}
		else {
			return 0;
		}
	}
	
	
	public abstract boolean isCorrect() throws GameNotPlayedException;

	
}
