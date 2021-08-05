
public class Test {

	public static void main(String[] args) {
		int[] list = { 67, 33, 21, 84, 49, 50, 75 };
		Integer [] list2 = { 67, 33, 21, 84, 49, 50, 75 };
//selection sort
		printList(list);
		Sort.selectionSort(list);
		printList(list);
//insertion sort
		System.out.println();
		shuffle(list);
		printList(list);
		Sort.insertionSort(list);
		printList(list);
//bubble sort
		System.out.println();
		shuffle(list);
		printList(list);
		Sort.bubbleSort(list);
		printList(list);
//merge sort
		System.out.println();
		shuffle(list);
		printList(list);
		Sort.mergeSort(list);
		printList(list);
// quick sort
		System.out.println();
		shuffle(list);
		printList(list);
		Sort.quickSort(list);
		printList(list);
//Heap sort
		System.out.println();
		printList(list2);
		Sort.heapSort(list2);
		printList(list2);
	}

	public static void printList(int[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
	
	public static void printList(Integer[] list) {
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}

	public static void shuffle(int[] list) {

		for (int i = 0; i < list.length; i++) {
			int j = (int) (Math.random() * list.length);
			int k = (int) (Math.random() * list.length);
			int temp = list[j];

			list[j] = list[k];
			list[k] = temp;

		}
	}

}