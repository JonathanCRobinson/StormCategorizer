/*
 * Jonathan Robinson
 * COP2552 OBJ ORIENT PG 2
 * Project 4 Storm Organizer
 * March 2023
 */

public class Hurricane {
	// Fields
	private String name;
	private int category;
	private String date;
	
	// Creates the hurricane object
	Hurricane(String n, int c, String d){
		this.name = n;
		this.category = c;
		this.date = d;
	}
	
	// Returns the values of the hurricane object
	public String GetName() {
		return name;
	}
	public int GetCategory() {
		return category;
	}
	public String GetDate() {
		return date;
	}
	
	// Separates the month from the date.
	public int GetMonth() {
		String[] month = GetDate().split("[/]");
		int m = Integer.parseInt(month[0]);
		return m;
	}
	// Separates the year from the date.
	public int GetYear() {
		String[] year = GetDate().split("[/]");
		int y = Integer.parseInt(year[2]);
		return y;
	}
}
