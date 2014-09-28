package sport.item;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import sport.GameNotPlayedException;
import sport.ScoreType;
import sport.WinnerType;

import bet.Odds;


@Entity
public class Game extends Item {
	private Season season;
	private Timestamp startTime;
	
	private Team homeTeam;
	private Team awayTeam;
	
	private int homeTeamScore;
	private int awayTeamScore;
	
	
	private boolean played;
	
	
	public Game() {
		
	}
	
	public Game(Season season, Timestamp startTime, Team homeTeam, Team awayTeam, int homeTeamScore, int awayTeamScore) {
		this.season = season;
		this.startTime = startTime;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeTeamScore = homeTeamScore;
		this.awayTeamScore = awayTeamScore;
		this.played = true;
	}
	
	public Game(Season season, Timestamp startTime, Team homeTeam, Team awayTeam) {
		this.season = season;
		this.startTime = startTime;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.played = false;
	}
	
	// ============
	// Fields start
	// ============
	
	@Column(nullable=false)
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@ManyToOne
	@JoinColumn(nullable=false)
	public Season getSeason() {
		return season;
	}
	public void setSeason(Season season) {
		this.season = season;
	}

	@ManyToOne
	@JoinColumn(nullable=false)
	public Team getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	@ManyToOne
	@JoinColumn(nullable=false)
	public Team getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	public int getHomeTeamScore() throws GameNotPlayedException {
		if (!played) {
			throw new GameNotPlayedException(this);
		}
		return this.homeTeamScore;
	}
	public void setHomeTeamScore(int homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	
	public int getAwayTeamScore() throws GameNotPlayedException {
		if (!played) {
			throw new GameNotPlayedException(this);
		}
		return this.awayTeamScore;
	}
	public void setAwayTeamScore(int awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	
	public boolean getPlayed() {
		return played;
	}
	public void setPlayed(boolean played) {
		this.played = played;
	}
	
	// ==========
	// Fields end
	// ==========
	
	@Override
	public String toString() {
		String result = "Game: " + homeTeam.getName() + "-" + awayTeam.getName() + " on " + startTime;
		if (played) {
			result += ", result: " + homeTeamScore + "-" + awayTeamScore + " ";
		}
		return result;
	}
	
	@Transient
	public WinnerType getWinner() throws GameNotPlayedException {
		if (played) {
			return Game.getResult(homeTeamScore, awayTeamScore);
		}
		else {
			throw new GameNotPlayedException(this);
		}
	}
	
	@Transient
	public ScoreType getScore(double limit) throws GameNotPlayedException {
		if (played) {
			return Game.getScore(homeTeamScore, awayTeamScore, limit);
		}
		else {
			throw new GameNotPlayedException(this);
		}
	}
	
	
	public static Game findById(int id) {
		return (Game) Item.findById(Game.class.getSimpleName(), id);
	}


	
	public static WinnerType getResult(int homeScore, int awayScore) {
		if (homeScore > awayScore) {
			return WinnerType.HOME;
		}
		else if (homeScore == awayScore) {
			return WinnerType.DRAW;
		}
		else {
			return WinnerType.AWAY;
		}
	}
	
	public static ScoreType getScore(int homeScore, int awayScore, double limit) {
		int totalScore = homeScore + awayScore;
		if (totalScore > limit) {
			return ScoreType.OVER;
		}
		else {
			return ScoreType.UNDER;
		}
	}




}
