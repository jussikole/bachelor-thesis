package sport.set;


import item.set.ItemSet;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import sport.item.Game;
import sport.item.Season;

import bet.bookie.Bookie;




public class GameSet implements ItemSet<Game> {
	private Season season;
	private TeamSet countryTeams;
	private ArrayList<Game> games;
	

	public GameSet(Season season) {
		super();
		this.games = new ArrayList<Game>();
		this.season = season;
	}
	
	public Season getSeason() {
		return season;
	}
	
	public GameSet subset(int start, int end) {
		GameSet newSet = new GameSet(season);
		for (int i=0; i<end; i++) {
			newSet.add(this.get(i));
		}
		return newSet;
 	}
	
	@Override
	public void add(Game item) {
		games.add(item);
	}

	@Override
	public Iterator<Game> iterator() {
		return games.iterator();
	}

	@Override
	public Game get(int id) {
		return games.get(id);
	}

	@Override
	public void save() {
		for (Game game : this) {
			game.save();
		}
	}


	
}
