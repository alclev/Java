
public class Lab extends Room {

	private int computers;

	public Lab() {
		super();
		computers = 0;
	}

	public Lab(String number, int capacity, int area, int computers) {
		super(number, capacity, area);
		this.computers = computers;
	}

	public int getComputers() {
		return computers;
	}

	public void setComputers(int computers) {
		this.computers = computers;
	}
	public String toString() {
		return String.format("%s%d", super.toString(), computers);
	}
}
