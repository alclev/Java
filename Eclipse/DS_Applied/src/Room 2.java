
public abstract class Room implements Comparable<Room> {

	private String number;
	private int capacity;
	private int area;

	protected Room() { //added default just for good measure
		number = "none";
		capacity = 0;
		area = 0;
	}

	protected Room(String number, int capacity, int area) {
		this.number = number;
		this.capacity = capacity;
		this.area = area;
	}

	public String getNumber() {
		return number;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getArea() {
		return area;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String toString() {
		return String.format("%-15s%-15s%-10s", number, capacity, area);
	}

	@Override
	public int compareTo(Room r) {
		if (capacity > r.getCapacity()) {
			return 1;
		}
		if (capacity < r.getCapacity()) {
			return -1;
		}
		return 0;
	}

}
