package bet.bookie;

import io.db.HibernateUtil;

import java.util.Collection;
import java.util.HashMap;

import org.hibernate.Query;


public class BookieManager {
	private HashMap<String, Bookie> bookies;
	
	public BookieManager() {
		
	}
	
	public Bookie getByAbbreviation(String abbreviation) {
		return bookies.get(abbreviation);
	}
	
	public void load() {
		Query query = HibernateUtil.createQuery("FROM Bookie");
		Bookie bookie;
		for (Object o : query.list()) {
			bookie = (Bookie) o;
			bookies.put(bookie.getAbbreviation(), bookie);
		}
	}
	
	public void parseHeader(String[] header) {
		
	}
	
	public Collection<Bookie> getBookies() {
		return bookies.values();
	}
	
	
}
