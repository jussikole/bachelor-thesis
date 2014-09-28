package sport.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class League extends Item {
	private Country country;
	private String name;
	
	public League() {
		
	}
	
	public League(Country country, String name) {
		this.country = country;
		this.name = name;
	}
	
	// ============
	// Fields start 
	// ============
	
	@ManyToOne
	public Country getCountry() {
		return this.country;
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

	public static League findById(int id) {
		return (League) Item.findById(League.class.getSimpleName(), id);
	}
	
	public static League findByName(String name) {
		return (League) Item.findByName(League.class.getSimpleName(), name);
	}

	@Override
	public String toString() {
		return "League: " + name + " (" + country.getName() + ")";
	}

	
}
