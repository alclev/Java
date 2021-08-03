
public class Course implements Comparable<Course> {

	private String number;
	private int credits;

	public Course(String number, int cr) {
		this.number = number;
		credits = cr;
	}

	public String getNumber() {
		return number;
	}

	public int getCredits() {
		return credits;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setCredits(int cr) {
		credits = cr;
	}

	public String toString() {
		return String.format("%-4s%d%-1s", "(" + number + ", ", credits, ")");
	}

	@Override
	public int compareTo(Course o) {
		return number.compareTo(o.getNumber());
	}

}
