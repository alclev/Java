/**
 * 
 * @author alexclevenger
 *@version 0.1 
 *Date of creation: April 22, 2021 
 *Last Date Modified: April 28, 2021
 *
 *Class country to model a country
 */
public class Country implements Comparable<Country>{
//private data members
	private String code;
	private String name;
	private double area;
//constructors
	public Country() {
		code = "none";
		name = "none";
		area = 0;
	}

	public Country(String code, String name, double area) {
		this.code = code;
		this.name = name;
		this.area = area;
	}
/**
 * Accessor for data member code
 * @param no parameters
 * @return String 
 * 
 */
	public String getCode() {
		return code;
	}
	/**
	 * Accessor for data member name
	 * @param no parameters
	 * @return String 
	 * 
	 */
	public String getName() {
		return name;
	}
	/**
	 * Accessor for data member area
	 * @param no parameters
	 * @return double 
	 * 
	 */
	public double getArea() {
		return area;
	}
	/**
	 * Mutator for data member code
	 * @param code
	 * @return no return value 
	 * 
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * Mutator for data member name
	 * @param name
	 * @return no return value 
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Mutator for data member area
	 * @param area
	 * @return no return value 
	 * 
	 */
	public void setArea(double area) {
		this.area = area;
	}
	/**
	 * toString method to display information of a country in a formatted string
	 * @param no parameters
	 * @return String
	 */
	public String toString() {
		return String.format("%-5s%-50s%-10.1f", code, name, area);
	}
/**
 * Definition of how to compare two countries
 * @param o
 * @return int 
 */
	@Override
	public int compareTo(Country o) {
		return name.compareTo(o.getName());
		
	}
}
