
import java.util.Arrays;

/**
 * Implements a Max Heap data structure using an array with each node in Max Heap contains a process. 
 * @author Mario Torres
 */

public class MaxHeap {
	private static final int DEFAULT_CAPACITY = 15;
	private Process[] heapArray;
	private int rear;

	/**
	 * Max Heap Constructor
	 */
	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Max Heap Constructor initializes array to be size passed in parameter 
	 * @param initialCapacity the initial size of array/heap
	 */
	public MaxHeap(int initialCapacity) {
		heapArray = new Process[initialCapacity - 1];
		rear = 0;
	}
	
	/**
	 * Build's a maxHeap from an array list of processes
	 * @param processes - array list containing processes 
	 */
	public void buildMaxHeap(Process[] processes) {
		heapArray = new Process[processes.length];
		heapArray = processes;
		rear = processes.length;
		expandIfNecessary();
		
		for (int i = processes.length / 2; i >= 0; i--) {
			maxHeapify(i);
		}
	}
	/**
	 * maxHeapifyUp moves a process up relative to it's parent
	 * @param index is the position in the heap to maxHeapifyUp from
	 */
	public void maxHeapifyUp(int index) {
		while (index > 0 && heapArray[parent(index)].compareTo(heapArray[index]) == -1) {
			exchange(index, parent(index));
			index = parent(index);
		}
	}

	/**
	 * maxHeapify from a given index position 
	 * @param index is the position in the heap to maxHeapify from
	 */
	public void maxHeapify(int index) {
		int left = leftChild(index);
		int right = rightChild(index);
		int largest = index;
		if (left < rear && heapArray[left].compareTo(heapArray[largest]) == 1) {
			largest = left;
		}
		if (right < rear && heapArray[right].compareTo(heapArray[largest]) == 1) {
			largest = right;
		}
		if (largest != index) {
			exchange(largest, index);
			maxHeapify(largest);
		}
	}

	/**
	 * Inserts a Process in heap
	 * @param Process to be inserted
	 */
	public void maxHeapInsert(Process data) {
		expandIfNecessary();
		heapArray[rear] = data;
		maxHeapifyUp(rear);
		rear++;
	}

	/**
	 * Extracts and returns the root node of the heap.
	 */
	public Process maxHeapExtract() {
		Process returnProcess = heapArray[0];
		exchange(0, rear - 1);
		rear--;
		maxHeapify(0);
		return returnProcess;
	}
	
	/**
	 * Returns the root of a maxHeap
	 * @return first position of heapArray
	 */
	public Process heapMaximum() {
		return heapArray[0];
	}

	/**
	 * Deletes and returns a node from the heap
	 * @param index is the node position to be deleted
	 */
	public Process maxHeapDelete(int index) {
		Process returnProcess = heapArray[index];
		boolean bigger = false;
		boolean smaller = false;
		if (returnProcess.compareTo(heapArray[rear - 1]) == 1) {
			smaller = true;
		}
		if (returnProcess.compareTo(heapArray[rear - 1]) == -1) {
			bigger = true;
		}
		exchange(index, rear - 1);
		rear--;
		if (smaller) {
			maxHeapify(index);
		}
		if (bigger) {
			maxHeapifyUp(index);
		}
		return returnProcess;
	}

	/**
	 * Returns the size of the Max Heap
	 */
	public int size() {
		return rear;
	}

	/**
	 * Returns the Max Heap array.
	 */
	public Process[] getHeapArray() {
		return heapArray;
	}

	/**
	 * Sets the Max Heap array
	 * @param heapArray
	 */
	public void setHeapArray(Process[] heapArray) {
		this.heapArray = heapArray;
	}

	/**
	 * Expands the array size if needed
	 */
	private void expandIfNecessary() {
		if (rear == heapArray.length) { // calculation of the array
			heapArray = Arrays.copyOf(heapArray, heapArray.length * 2);
		}
	}

	/**
	 * Returns the the parent node in a heap
	 * @param index of child node
	 */
	private int parent(int index) {
		if (index == 0) {
			return 0;
		}
		return (index - 1)  / 2;
	}

	/**
	 * Returns the left child in heap
	 * @param index of parent to find left child
	 */
	private int leftChild(int index) {
		return (2 * index) + 1;
	}

	/**
	 * Returns the right child in heap
	 * @param index of parent to find right child
	 */
	private int rightChild(int index) {
		return (2 * index) + 2;
	}

	/**
	 * Swaps one element position with another in heap
	 * @param first  is one of the element to be swapped in heap
	 * @param second is the element to swap with in heap
	 */
	private void exchange(int first, int second) {
		Process tmpProcess;
		tmpProcess = heapArray[first];
		heapArray[first] = heapArray[second];
		heapArray[second] = tmpProcess;
	}
	
	/**
	 * Returns if the index position is a leaf of the heap
	 * @param index - position to check 
	 * @return true if a leaf and false if not
	 */
    private boolean isLeaf(int index)
    {
        if (index > (size() / 2) && index <= size()) {
            return true;
        }
        return false;
    }
	
	/**
	 * Prints the parent, left child, and right child starting at the root and working down
	 * Used to test maxHeapify in Test.java
	 */
    public void print() {
        for (int i = 0; i < rear / 2; i++) {
        	if(!isLeaf(i)) {
        		System.out.print("PARENT : " + heapArray[i] + " LEFT CHILD : " + heapArray[2 * i + 1] + " RIGHT CHILD : " + heapArray[2 * i + 2]);
        		System.out.println();
        	}
        }
    }

}