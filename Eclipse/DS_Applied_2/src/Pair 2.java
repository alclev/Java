
public class Pair<E1, E2> {

	private E1 first;
	private E2 second;

	public Pair(E1 f, E2 s) {
		first = f;
		second = s;
	}

	public E1 getFirst() {
		return first;
	}

	public E2 getSecond() {
		return second;
	}

	public void setFirst(E1 f) {
		first = f;
	}

	public void setSecond(E2 s) {
		second = s;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Pair) {
			Pair<E1, E2> p = (Pair<E1, E2>) obj;
			return this.first.equals(p.first) && this.second.equals(p.second);
		}
		return false;
	}

	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}
