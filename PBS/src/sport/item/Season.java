package sport.item;


import io.db.HibernateUtil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.Query;
import org.hibernate.Session;


@Entity
public class Season extends Item {
	private League league;
	private int year;
	
	public Season() {
		
	}
	
	public Season(League league, int year) {
		this.league = league;
		this.year = year;
	}
	
	// ============
	// Fields start
	// ============
	
	@ManyToOne
	public League getLeague() {
		return this.league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	// ==========
	// Fields end
	// ==========

	public static Season findById(int id) {
		return (Season) Item.findById(Season.class.getSimpleName(), id);
	}
	
	public static Season find(League league, int year) {
		Query query = HibernateUtil.createQuery("FROM Season WHERE league = :league AND year = :year");
		query.setParameter("league", league);
		query.setParameter("year", year);
		return (Season) query.uniqueResult();
	}
	
	public static Season find(String leagueName, int year) {
		Query query = HibernateUtil.createQuery("FROM Season AS S WHERE S.league.name = :leagueName AND S.year = :year");
		query.setParameter("leagueName", leagueName);
		query.setParameter("year", year);
		return (Season) query.uniqueResult();
	}

	@Override
	public String toString() {
		return "Season: " + year + " in " + league.getName();
	}
	
	
}
