
public class Student extends Person implements Comparable<Student> {

	private int id;
	private int totalCredits;
	private BST<Course> courses = new BST<>();

	public Student(String name, int id) {
		super(name);
		this.id = id;
		totalCredits = 0;

		BST<Course> courses = new BST<Course>();

	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int tc) { // added just in case
		totalCredits = tc;
	}

	public boolean addCourse(String number, int cr) {

		if (courses.insert(new Course(number, cr))) {
			totalCredits += cr;
			return true;
		}
		return false;
	}

	public Course findCourse(String number) {
		Course c = new Course(number, 0);
		return courses.search(c);
	}

	public boolean dropCourse(String number) {
		Course c = new Course(number, 0);
		int cred = courses.search(c).getCredits();
		if (courses.delete(c)) {
			totalCredits -= cred;
			return true;
		}
		return false;
	}

	public String courseList() {
		return courses.toString();
	}

	public String toString() {
		return String.format("%-10d%-25s%-20d%-40s\n", id, super.toString(), totalCredits, courseList());
	}

	@Override
	public int compareTo(Student s) {
		Integer i = totalCredits;
		return i.compareTo(s.getTotalCredits());
	}

	public boolean equals(Object o) {
		return this.equals(o);
	}
}
