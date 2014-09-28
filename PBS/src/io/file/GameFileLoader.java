package io.file;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import sport.item.Country;
import sport.item.League;
import sport.item.Season;
import sport.set.GameSet;
import tools.FileTools;


public class GameFileLoader {
	private static final File RESOURCES_FOLDER = new File("resources");
	
	public GameFileLoader() {

	}
	
	public void load(String format, Country country, League league) throws IOException, ParseException {
		File leagueFolder = createLeagueFolder(country, league);
		for (File file : leagueFolder.listFiles()) {
			this.load(file, league, Integer.parseInt(FileTools.removeExtension(file)));
		}
	}
	

	public void load(String format, Country country, League league, int year) throws IOException, ParseException {
		File leagueFolder = createLeagueFolder(country, league);	
		File gameFile = FileTools.combine(leagueFolder, FileTools.addExtension(Integer.toString(year), format));
		this.load(gameFile, league, year);
	}
	
	public void load(File file, League league, int year) throws IOException, ParseException {
		Season season = new Season(league, year);
		season.save();
		// GameSet games = new GameSet(file, season);
		// games.save();
	}
	
	private File createLeagueFolder(Country country, League league) {
		return FileTools.combine(RESOURCES_FOLDER, country.getName(), league.getName().replace(' ', '_'));
	}
	
	public static void main(String[] args) {
		/*
		HibernateUtil.startSession();
		HibernateUtil.begin();
		Country country = new Country("England", "ENG");
		country.save();
		League league = new League(country, "Premier league");
		league.save();
		
		GameFileLoader loader = new GameFileLoader(new FootballDataCoUkHeader());
		boolean success = true;
		try {
			loader.load("csv", country, league);
		} catch (IOException e) {
			e.printStackTrace();
			success = false;
		} catch (ParseException e) {
			e.printStackTrace();
			success = false;
		}
		
		HibernateUtil.commit(success);
		HibernateUtil.closeSession();
		*/
	}
}
