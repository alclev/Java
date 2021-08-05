import java.util.ArrayList;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: May 7, 2021 
 * Last Date Modified: May 10, 2021
 * @param <E>
 * 
 * Class test to test the performance of different sorting algorithms
 */
public class Test {

	public static void main(String[] args) {

		ArrayList<Integer> randomList = new ArrayList<>();
		ArrayList<Integer> sortedList = new ArrayList<>();
		ArrayList<Integer> reversedList = new ArrayList<>();
		
		for (int i = 0; i < 10000; i++) {
			randomList.add(i); // adds integers 0-9999
		}
		java.util.Collections.shuffle(randomList); // randomize the list

		sortedList = (ArrayList<Integer>) randomList.clone();

		java.util.Collections.sort(sortedList); // sorts the list

		reversedList = (ArrayList<Integer>) sortedList.clone();
		java.util.Collections.reverse(reversedList);

		// application of the sorting algorithms

		
		int [] random = new int[6]; //arrays for storing iterations for each list 
		int [] sort = new int[6];
		int [] rev = new int[6];
		// selection sort
		
		Sort.selectionSort(randomList);
		random[0] = Sort.iterations[0]; 
		Sort.selectionSort(sortedList);
		sort[0] = Sort.iterations[0];
		Sort.selectionSort(reversedList);
		rev[0] = Sort.iterations[0];
		java.util.Collections.shuffle(randomList);
		java.util.Collections.reverse(reversedList);
		
		//insertion sort
		Sort.insertionSort(randomList);
		random[1] = Sort.iterations[1];
		Sort.insertionSort(sortedList);
		sort[1] = Sort.iterations[1];
		Sort.insertionSort(reversedList);
		rev[1] = Sort.iterations[1];
		java.util.Collections.shuffle(randomList);
		java.util.Collections.reverse(reversedList);
		
		//bubble sort
		Sort.bubbleSort(randomList);
		random[2] = Sort.iterations[2];
		Sort.bubbleSort(sortedList);
		sort[2] = Sort.iterations[2];
		Sort.bubbleSort(reversedList);
		rev[2] = Sort.iterations[2];
		java.util.Collections.shuffle(randomList);
		java.util.Collections.reverse(reversedList);
		
		//merge sort
		Sort.mergeSort(randomList);
		random[3] = Sort.iterations[3];
		Sort.iterations[3] = 0;  //reset to zero
		Sort.mergeSort(sortedList);
		sort[3] = Sort.iterations[3];
		Sort.iterations[3] = 0; //reset to zero
		Sort.mergeSort(reversedList);
		rev[3] = Sort.iterations[3];
		java.util.Collections.shuffle(randomList);
		java.util.Collections.reverse(reversedList);

		//quick sort
		Sort.quickSort(randomList);
		random[4] = Sort.iterations[4];
		Sort.iterations[4] = 0; //reset to zero
		Sort.quickSort(sortedList);
		sort[4] = Sort.iterations[4];
		Sort.iterations[4] = 0; //reset to zero
		Sort.quickSort(reversedList);
		rev[4] = Sort.iterations[4];
		java.util.Collections.shuffle(randomList);
		java.util.Collections.reverse(reversedList);
		
		//heap sort
		Sort.heapSort(randomList);
		random[5] = Sort.iterations[5];
		Sort.iterations[5] = 0; //reset to zero
		Sort.heapSort(sortedList);
		sort[5] = Sort.iterations[5];
		Sort.iterations[5] = 0; //reset to zero
		Sort.heapSort(reversedList);
		rev[5] = Sort.iterations[5];
		java.util.Collections.shuffle(randomList);
		java.util.Collections.reverse(reversedList);
		
		String[] topLine = { "Sorting Algorithm", "Random List", "Sorted List", "Reversed List" };
		String[] algorithms = { "Selection Sort" ,"Insertion sort", "Bubble sort", "Merge Sort", "Quick sort", "Heap sort" };

		System.out.printf("%-20s%-15s%-15s%-15s\n", topLine[0], topLine[1], topLine[2], topLine[3]);

		for(int i = 0; i < 6; i++) {
			System.out.printf("%-20s%-15d%-15d%-15d\n", algorithms[i], random[i], sort[i], rev[i]);
		}
	}
	
	/**
	 * Discussion:
	 * 
	 *  
	 * To compare the performance of each sorting algorithm on the different data sets:
	 * 
	 * The performance for the selection sort remained the same for each of the data sets.
	 * The performance for the insertion sort was the worst for the reversed list, and by far the best for the sorted list.
	 * 		the random was somewhere in the middle.
	 * The performance for the bubble sort the worst for the reversed list, second to worst for the random, and 
	 * by far the best for the sorted list. 
	 * The performance for the merge sort remained the same for each data set. 
	 * The performance for the quick sort was the best for the random list, and worse and the same for 
	 * the sorted and reversed lists. 
	 * The performance for the heap sort was the best for the reversed list, second best for the random list, 
	 * and the worst for the sorted list. 
	 * 
	 * 
	 * To compare the performance of the sorting algorithms to each other:
	 * 
	 * In general, the selection sort demonstrated the worst performance with 50004999 iterations for each 
	 * data set. In general, the heap sort demonstrated the best performance. The merge sort had 287231
	 * iterations for each data set, which is generally lower than that of the quick sort, bubble sort, and insertion sort,
	 * but the iterations for those vary depending on the data set. 
	 */

}
