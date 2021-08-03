
public class Office extends Room {

	private String owner;

	public Office() {
		super();
		owner = "none";
	}

	public Office(String number, int capacity, int area, String owner) {
		super(number, capacity, area);
		this.owner = owner;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String toString() {
		return String.format("%s%-20s", super.toString(), owner);
	}
}
