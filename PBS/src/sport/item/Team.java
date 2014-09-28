package sport.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Team extends Item {
	
	
	private Country country;
	private String name;
	
	public Team() {
		
	}
	
	public Team(Country country, String name) {
		this.setCountry(country);
		this.name = name;
	}
	
	// ============
	// Fields start
	// ============
	
	@ManyToOne
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Column(unique=true)
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// ==========
	// Fields end
	// ==========
	
	public static Team findById(int id) {
		return (Team) Item.findById(Team.class.getSimpleName(), id);
	}
	
	public static Team findByName(String name) {
		return (Team) Item.findByName(Team.class.getSimpleName(), name);
	}

	@Override
	public String toString() {
		return "Team: " + name + " (" + country.getName() + ")";
	}

}
