import java.util.ArrayList;
/**
 * 
 * @author alexclevenger
 * @version 0.1 
 * Date of creation: May 7, 2021 
 * Last Date Modified: May 10, 2021
 * @param <E>
 * 
 * Class Sort that contains different sorts
 */
public class Sort {

	public static int[] iterations = new int[6];

	/**
	 *  Selection sort method
	 * @param list
	 * @return no return value
	 * 
	 *         O(n^2)
	 */
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		int minIndex;
		iterations[0] = 0;
		for (int i = 0; i < list.size() - 1; i++) { // O(n)
			iterations[0]++;
			E min = list.get(i);
			minIndex = i;
			for (int j = i + 1; j < list.size(); j++) { // O(n)
				iterations[0]++;
				if (list.get(j).compareTo(min) < 0) {
					min = list.get(j);
					minIndex = j;
				}
			}
			E temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
		}
	}
	/**
	 * Generalized Selection sort method
	 * @param list
	 * @return no return value
	 * 
	 *         O(n^2)
	 */
	public static <E extends Comparable<E>> void selectionSort(E[] list) {
		int minIndex;
		for (int i = 0; i < list.length - 1; i++) {
			E min = list[i];
			minIndex = i;
			for (int j = i; j < list.length; j++) {
				if (list[j].compareTo(min) < 0) {
					min = list[j];
					minIndex = j;
				}
			}
			E temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
		}
	}

	/**
	 *  insertion sort method
	 * @param list
	 * @return no return value
	 * 
	 * 		O(n^2)
	 */
	public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) {
		iterations[1] = 0;
		for (int i = 1; i < list.size(); i++) {
			iterations[1]++;
			// Insert element i in the sorted sub-list
			E currentVal = list.get(i);
			int j = i;
			while (j > 0 && currentVal.compareTo(list.get(j - 1)) < 0) {
				iterations[1]++;
				// Shift element (j-1) into element (j)
				list.set(j, list.get(j - 1));
				j--;
			}
			// Insert currentVal at position i
			list.set(j, currentVal);
		}
	}

	/**
	 * bubble sort method
	 * 
	 * @param list
	 * @return no return value
	 * 
	 * 		O(n^2)
	 */
	public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) {
		boolean sorted = false;
		iterations[2] = 0;
		for (int k = 1; k < list.size() && !sorted; k++) {
			iterations[2]++;
			sorted = true;
			for (int i = 0; i < list.size() - k; i++) {
				iterations[2]++;
				if (list.get(i).compareTo(list.get(i + 1)) > 0) {
					// swap
					E temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
					sorted = false;
				}
			}
		}
	}

	/**
	 * O(n log n)
	 * 
	 * mergeSort method
	 * 
	 * @param list
	 * @return no return value
	 */
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		iterations[3]++;
		if (list.size() > 1) { // base case
			ArrayList<E> firstHalf = subList(list, 0, list.size() / 2);
			ArrayList<E> secondHalf = subList(list, list.size() / 2, list.size());

			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list); // O(n) * O(log n) = O (n log n)
		}
	}
/**
 * makes sublists for method mergeSort
 * @param list
 * @param start
 * @param end
 * @return no return value
 */
	public static <E extends Comparable<E>> ArrayList<E> subList(ArrayList<E> list, int start, int end) {

		ArrayList<E> newList = new ArrayList<>();
		for (int i = start; i < end; i++) {
			iterations[3]++;
			newList.add(list.get(i));
		}
		return newList;
	}

	// O(n)
	/**
	 * Method that merges sublists together for method MergeSort
	 * @param list1
	 * @param list2
	 * @param list
	 * @return no return value
	 */
	public static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
		int list1Index = 0;
		int list2Index = 0;
		int listIndex = 0;
		while (list1Index < list1.size() && list2Index < list2.size()) {
			iterations[3]++;
			if (list1.get(list1Index).compareTo(list2.get(list2Index)) < 0)
				list.set(listIndex++, list1.get(list1Index++));
			else
				list.set(listIndex++, list2.get(list2Index++));
		}
		while (list1Index < list1.size()) {
			iterations[3]++;
			list.set(listIndex++, list1.get(list1Index++));
		}
		while (list2Index < list2.size()) {
			list.set(listIndex++, list2.get(list2Index++));
			iterations[3]++;
		}
	}

	/**
	 * 
	 * @param list
	 * @return
	 * 
	 * 		Average case: O(n log n) Worst case: O(n^2)
	 * 
	 *         Partitioning the array in halves: O(log n) Arranging elements around
	 *         the pivot: O(n)
	 * 
	 *         Partitioning the array not in halves: O(n) //worst case Arranging
	 *         elements around the pivot: O(n)
	 * 
	 * 
	 * 
	 */

	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) {
		quickSort(list, 0, list.size() - 1);
	}
/**
 * recursive helper method for method quickSort(ArrayList<E> list)
 * @param list
 * @param first
 * @param last
 */
	public static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int first, int last) {
		iterations[4]++;
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
/**
 * Method that places pivot in correct position and returns the pivot index
 * @param list
 * @param first
 * @param last
 * @return int
 */
	public static <E extends Comparable<E>> int partition(ArrayList<E> list, int first, int last) {
		E pivot;
		int index, pivotIndex;
		pivot = list.get(first);// pivot is the first element
		pivotIndex = first;
		for (index = first + 1; index <= last; index++) {
			iterations[4]++;
			if (list.get(index).compareTo(pivot) < 0) {
				pivotIndex++;
				swap(list, pivotIndex, index);
			}
		}
		swap(list, first, pivotIndex);
		return pivotIndex;
	}
/**
 * method that swaps elements in a list
 * @param list
 * @param i
 * @param j
 */
	public static <E> void swap(ArrayList<E> list, int i, int j) {
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);

	}
/**
 * Method for a heap sort
 * 
 * @param list
 * @return no return value 
 * 
 * O(n log n)
 */
	public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
		Heap<E> heap = new Heap<>(list);
		for (int i = list.size() - 1; i >= 0; i--) {
			iterations[5]++;
			list.set(i, heap.delete());
		}
	}

}
