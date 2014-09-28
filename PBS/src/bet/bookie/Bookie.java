package bet.bookie;

import java.util.Set;

import javax.persistence.Entity;

import sport.item.Item;

import bet.Odds;

@Entity
public class Bookie extends Item {
	
	private String name;
	private String abbreviation;
	
	public Bookie() {

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	@Override
	public String toString() {
		return "Bookmarker: " + name + " (" + abbreviation + ")";
	}
}
