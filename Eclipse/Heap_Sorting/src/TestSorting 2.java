import java.util.ArrayList;
import java.util.Random;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: May 7, 2021 
 * Last Date Modified: May 10, 2021
 * @param <E>
 * 
 * Testing class for the sorts
 *
 */
public class TestSorting {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			list.add(random.nextInt(100000));

		}

		// selection sort
		Sort.selectionSort(list);
		java.util.Collections.shuffle(list);

		// insertion sort
		Sort.insertionSort(list);
		java.util.Collections.shuffle(list);

		// bubble sort
		Sort.bubbleSort(list);
		java.util.Collections.shuffle(list);

		// merge sort
		Sort.mergeSort(list);
		java.util.Collections.shuffle(list);

		// quick sort
		Sort.quickSort(list);
		java.util.Collections.shuffle(list);

		// heap sort
		System.out.println("Size: " + list.size());
		System.out.println();
		Sort.heapSort(list);
		System.out.printf("%-15s\t%-10s\n", "Sorting Algorithm", "Number of Iterations");
		
		String[] algorithms = {"Selection sort", "Insertion sort", "Bubble sort", "Merge Sort", "Quick sort", "Heap sort"};
		for (int i = 0; i < 6; i++) {
			System.out.printf("%-15s\t\t%-10d\n", algorithms[i], Sort.iterations[i]);
		}

	}
	/**
	 * Discussion:
	 * 
	 * As discussed in class, the worst case for merge sort and heap sort is always going to be O(n log n)
	 * whereas the worst case for the bubble, selection, and insertion sort is always going to be O(n^2).
	 * Selection sort should not vary but the time complexity for the bubble and insertion sort is worse
	 * for reversed lists. Quicksort on the other hand can be O(n log n) or O(n^2) depending on how the 
	 * list is initially ordered. This is seen through the actual number of iterations because the number 
	 * of iterations for merge and selection sort does not vary while the others do slightly. Also,
	 * we can see that selection sort consistently has the highest number of iterations, followed by 
	 * selection, insertion, bubble, merge, quick, and heap sorts, respectively. 
	 */

}
