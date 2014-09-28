package sport.item;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Country extends Item {
	
	private String name;
	private String abbreviation;
	
	public Country() {
		
	}
	
	public Country(String name, String abbreviation) {
		this.name = name;
		this.abbreviation = abbreviation;
	}
	
	// ============
	// Fields start 
	// ============
	
	@Column(unique=true, nullable=false)
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(unique=true, nullable=false)
	public String getAbbreviation() {
		return this.abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	// ==========
	// Fields end
	// ==========

	public static Country findById(int id) {
		return (Country) Item.findById(Country.class.getSimpleName(), id);
	}
	
	public static Country findByName(String name) {
		return (Country) Item.findByName(Country.class.getSimpleName(), name);
	}

	@Override
	public String toString() {
		return "Country: " + name + "( " + abbreviation + ")";
	}

}
