import java.util.Iterator;

/**
 * 
 * @author alexclevenger
 *
 *         All O(1) except offer() O(n) and toString() O(n)
 *
 */
public class Test {

	public static void main(String[] args) {

		ArrayBasedList<String> cities = new ArrayBasedList<>();
		cities.add("New York");
		cities.add("San Diego");
		cities.add("Atlanta");
		cities.add("Baltimore");
		cities.add("Pittsburg");
		// toString() to display the content of the list
		System.out.println(cities.toString());
		// iterator to visit and display the elements of the list
		Iterator<String> cityIterator = cities.iterator();
		while (cityIterator.hasNext()) {
			System.out.print(cityIterator.next() + " ");
		}
		System.out.println();
		// get(index) to visit and display the elements of the list
		for (int i = 0; i < cities.size(); i++) {
			System.out.print(cities.get(i) + " ");
		}
//testing the linked list class
		LinkedList<String> cityList;
		cityList = new LinkedList<>();
		cityList.addFirst("Boston");
		cityList.addFirst("Philadelphia");
		cityList.addFirst("San Francisco");
		cityList.addFirst("Washington");
		cityList.addFirst("Portland");
		System.out.println("\n" + cityList.toString());
		Iterator<String> cityIteratorLL = cityList.iterator();
		System.out.print("City List (iterator): ");
		while (cityIteratorLL.hasNext()) {
			System.out.print(cityIteratorLL.next() + " ");
		}
// testing the stack class

		Stack<String> cityStack = new Stack<>();
		cityStack.push("New York");
		cityStack.push("San Diego");
		cityStack.push("Atlanta");
		cityStack.push("Baltimore");
		cityStack.push("Pittsburg");
		System.out.println("\nCity Stack (toString): " + cityStack.toString());
		System.out.print("City Stack (pop): ");
		while (!cityStack.isEmpty())
			System.out.print(cityStack.pop() + " ");

//testing the queue class

		Queue<String> cityQueue = new Queue<>();
		cityQueue.offer("New York");
		cityQueue.offer("San Diego");
		cityQueue.offer("Atlanta");
		cityQueue.offer("Baltimore");
		cityQueue.offer("Pittsburg");
		System.out.println("\nCity Queue (toString): " + cityQueue.toString());
		System.out.print("City Queue (poll): ");
		while (!cityQueue.isEmpty())
			System.out.print(cityQueue.poll() + " ");

//testing the priorityqueue class

		PriorityQueue<String> cityPriorityQueue = new PriorityQueue<>();
		cityPriorityQueue.offer("New York");
		cityPriorityQueue.offer("San Diego");
		cityPriorityQueue.offer("Atlanta");
		cityPriorityQueue.offer("Baltimore");
		cityPriorityQueue.offer("Pittsburg");
		System.out.println("\nCity Priority Queue: " + cityPriorityQueue.toString());
		System.out.print("City Priority Queue (poll): ");
		while (!cityPriorityQueue.isEmpty()) {
			System.out.print(cityPriorityQueue.poll() + " ");
		}
//testing the BST		
		BST<String> cityTree = new BST<>();
		cityTree.insert("New York");
		cityTree.insert("Washington");
		cityTree.insert("Boston");
		cityTree.insert("Philadelphia");
		cityTree.insert("Columbus");
		cityTree.insert("Baltimore");
		cityTree.insert("Atlanta");
		System.out.print("\nInitial Tree: ");
		cityTree.inorder();
		System.out.println();
		cityTree.delete("Columbus");
		System.out.print("Tree after removal: ");
		cityTree.inorder();
		System.out.println();

//testing the heap

		Heap<String> cityHeap = new Heap<>();
		cityHeap.insert("Atlanta");
		cityHeap.insert("Baltimore");
		cityHeap.insert("Boston");
		cityHeap.insert("Columbus");
		cityHeap.insert("New York");
		cityHeap.insert("Philadelphia");
		cityHeap.insert("Washington");
		System.out.print("Heap: ");
		System.out.println(cityHeap.toString());

//testing the HashMap
		HashMap<String, String> states = new HashMap<>(220);

		states.put("PA", "Pennsylvania");
		states.put("NY", "New York");
		states.put("MA", "Massachusetts");
		states.put("CA", "California");
		states.put("NJ", "New Jersey");
		states.put("OH", "Ohio");
		states.put("NM", "New Mexico");
		states.put("WA", "Washington");
		System.out.println(states);
		System.out.println("Code NJ is for " + states.get("NJ"));
		System.out.println("NY is in the map? " + states.containsKey("NY"));
		states.remove("MA");
		System.out.println(states);
		states.clear();
		System.out.println(states);
	}
}
