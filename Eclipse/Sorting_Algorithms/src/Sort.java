
public class Sort {

	/**
	 * 
	 * @param list
	 * @return no return value
	 * 
	 *         O(n^2)
	 */
	public static void selectionSort(int[] list) {
		int minIndex;
		for (int i = 0; i < list.length - 1; i++) { // O(n)
			int min = list[i];
			minIndex = i;
			for (int j = i + 1; j < list.length; j++) { // O(n)
				if (list[j] < min) {
					min = list[j];
					minIndex = j;
				}
			}
			int temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
		}
	}

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
	 * 
	 * @param list
	 * @return
	 * 
	 * 		O(n)
	 */
	public static void insertionSort(int[] list) {
		for (int i = 1; i < list.length; i++) {
			// Insert element i in the sorted sub-list
			int currentVal = list[i];
			int j = i;
			while (j > 0 && currentVal < (list[j - 1])) {
				// Shift element (j-1) into element (j)
				list[j] = list[j - 1];
				j--;
			}
			// Insert currentVal at position i
			list[j] = currentVal;
		}
	}

	/**
	 * 
	 * 
	 * @param list
	 * @return
	 * 
	 * 		O(n^2)
	 */
	public static void bubbleSort(int[] list) {
		boolean sorted = false;
		for (int k = 1; k < list.length && !sorted; k++) {
			sorted = true;
			for (int i = 0; i < list.length - k; i++) {
				if (list[i] > list[i + 1]) {
					// swap
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					sorted = false;
				}
			}
		}
	}

	/**
	 * O(n log n)
	 * 
	 * @param list
	 * @return
	 */
	public static void mergeSort(int[] list) {
		if (list.length > 1) { // base case
			int[] firstHalf = new int[list.length / 2];
			int[] secondHalf = new int[list.length - list.length / 2];
			System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
			System.arraycopy(list, list.length / 2, secondHalf, 0, list.length - list.length / 2);
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list); // O(n) * O(log n) = O (n log n)
		}
	}

	// O(n)
	public static void merge(int[] list1, int[] list2, int[] list) {
		int list1Index = 0;
		int list2Index = 0;
		int listIndex = 0;
		while (list1Index < list1.length && list2Index < list2.length) {
			if (list1[list1Index] < list2[list2Index])
				list[listIndex++] = list1[list1Index++];
			else
				list[listIndex++] = list2[list2Index++];
		}
		while (list1Index < list1.length)
			list[listIndex++] = list1[list1Index++];
		while (list2Index < list2.length)
			list[listIndex++] = list2[list2Index++];
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

	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}

	public static void quickSort(int[] list, int first, int last) {
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}

	public static int partition(int list[], int first, int last) {
		int pivot;
		int index, pivotIndex;
		pivot = list[first];// pivot is the first element
		pivotIndex = first;
		for (index = first + 1; index <= last; index++)
			if (list[index] < pivot) {
				pivotIndex++;
				swap(list, pivotIndex, index);
			}
		swap(list, first, pivotIndex);
		return pivotIndex;
	}

	public static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;

	}

	public static <E extends Comparable<E>> void heapSort(E[] list) {
		Heap<E> heap = new Heap<>(list);
		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.delete();
		}
	}

}
