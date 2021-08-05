
public class Main {
	
	public static void main(String[] args) {
		Girl Liv = new Girl();
		Boy Tom = new Boy();
		Human Pat= new Human();
		Organism thing= new Organism();
		Main re= new Main();
		
//		Liv.declare();
//		Tom.declare();
//		Pat.declare();
//		thing.declare();
		re.ref();
		
	}
	public void ref() {
		int n= 10;
		int k=n;
		int l=k;
		n--;
		System.out.println(n);
		System.out.println(k);
		System.out.println(l);
	}
}
