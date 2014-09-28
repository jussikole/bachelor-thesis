package sport.set;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pbs.file.parser.GameHeader;
import com.pbs.file.parser.TeamHeader;
import com.pbs.sql.HibernateUtil;
import com.pbs.sql.ItemSet;

public class TeamSet extends ItemSet<Team, TeamHeader> {
	private HashMap<String, Team> teams;
	
	public TeamSet() {
		super();
		teams = new HashMap<String, Team>();
	}
	
	@Override
	public void add(Team team) {
		teams.put(team.getName(), team);
		super.add(team);
	}
	
	public Team get(String name) {
		return teams.get(name);
	}
	
	public static TeamSet findByCountry(Country country) {
		Query query = HibernateUtil.createQuery("FROM Team AS T WHERE T.country = :country");
		query.setParameter("country", country);
		List<?> teams = query.list();
		TeamSet teamSet = new TeamSet();
		for (Object o : teams) {
			teamSet.add((Team) o);
		}
		return teamSet;
	}
	

	@Override
	public void parseLine(TeamHeader header, String[] line) {
		// TODO Auto-generated method stub
		
	}
}
