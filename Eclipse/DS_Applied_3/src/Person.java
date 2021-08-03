
public class Person {

	private String name;

	protected Person(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
