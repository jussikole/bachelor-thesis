package test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.hibernate.Session;

import com.pbs.file.parser.FootballDataCoUkHeader;
import com.pbs.sport.Country;
import com.pbs.sport.Game;
import com.pbs.sport.GameSet;
import com.pbs.sport.League;
import com.pbs.sport.Season;
import com.pbs.sport.Team;
import com.pbs.sport.TeamSet;
import com.pbs.sql.HibernateUtil;



public class ModelTest {
	public static void main(String[] args) {
		HibernateUtil.startSession();
		
		Country country = new Country("England", "ENG");
		League league = new League(country, "Premier league");
		Season season = new Season(league, 2011);
		
		country.save();
		league.save();
		season.save();
		
		File file = new File("C:\\Users\\jussi\\workspace\\PBS\\resources\\csv\\2\\3\\2011.csv");
		
		try {
			GameSet games = new GameSet(file, new FootballDataCoUkHeader(), season);
			for (Game g : games) {
				System.out.println(g.getHomeTeam().getName() + " " + g.getAwayTeam().getName());
			}
			HibernateUtil.begin();
			games.save();
			HibernateUtil.commit(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HibernateUtil.closeSession();
		

		
		
	}
}
