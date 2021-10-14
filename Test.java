

public class Test {

	public static void main(String[] args) {
		// Test maxHeapify with 5 processes, all different priorities 
		if(maxHeapify5()) {
			System.out.println("maxHeapify with 5 processes, all different priorities: Passed!");
		} else {
			System.out.println("maxHeapify with 5 processes, all different priorities: Failed");
		}
		
		System.out.println();
		
		// Test maxHeapify with 10 processes, some have same priorities 
		if(maxHeapify10()) {
			System.out.println("maxHeapify with 10 processes, some have same priorities: Passed!");
		} else {
			System.out.println("maxHeapify with 10 processes, some have same priorities: Failed");
		}
		
		System.out.println();
		
		// Test maxHeapify with 10 processes, all have same priorities 
		if(maxHeapifyAllSamePriority()) {
			System.out.println("maxHeapify with 10 processes, some have same priorities: Passed!");
		} else {
			System.out.println("maxHeapify with 10 processes, some have same priorities: Failed");
		}
	}
	 /**
	  * max heapify's 5 processes with different priorities
	  * @param list - Keeps track of processes
	  * @return true if highest priority process matches with expected output, false otherwise
	  */
	private static boolean maxHeapify5() {
		MaxHeap list = new MaxHeap(10);
		Process a = new Process(8, 3, 1);
		Process b = new Process(4, 6, 4);
		Process c = new Process(5, 7, 9);
		Process d = new Process(9, 9, 1);
		Process e = new Process(3, 3, 3);
		Process[] processes = {a, b, c, d, e};
		list.buildMaxHeap(processes);
		list.print();
		Process result = list.heapMaximum();
		Process expectedResult = d;
		System.out.println(result.toString());
		System.out.println(expectedResult.toString());
		if (result.compareTo(expectedResult) == 0) {
			return true;
		} else {
			return false;
		}	
	}
	
	/**
	 * Bigger 10 process max heap with some having same priority, calls maxheapify
	 * @param list - keeps track of processes
	 * @return the highest priority and first inserted process with highest priority, true if matches expected, false otherwise
	 */
	private static boolean maxHeapify10() {
		MaxHeap list = new MaxHeap(10);
		Process a = new Process(8, 3, 1);
		Process b = new Process(4, 6, 4);
		Process c = new Process(5, 7, 9);
		Process d = new Process(9, 9, 1);
		Process e = new Process(3, 3, 3);
		Process f = new Process(9, 8, 2);
		Process g = new Process(6, 6, 6);
		Process h = new Process(1, 2, 3);
		Process i = new Process(7, 9, 4);
		Process j = new Process(4, 3, 4);
		Process[] processes = {a, b, c, d, e, f, g, h, i, j};
		list.buildMaxHeap(processes);
		list.print();
		Process result = list.heapMaximum();
		Process expectedResult = d;
		System.out.println(result.toString());
		System.out.println(expectedResult.toString());
		if (result.compareTo(expectedResult) == 0) {
			return true;
		} else {
			return false;
		}	
	}
	
	/**
	 * 10 Process list, all have the same priority, with differing/same arrival time
	 * @return the first arriving, highest priority process
	 */
	private static boolean maxHeapifyAllSamePriority() {
		MaxHeap list = new MaxHeap(10);
		Process a = new Process(6, 3, 5);
		Process b = new Process(6, 6, 4);
		Process c = new Process(6, 7, 9);
		Process d = new Process(6, 9, 5);
		Process e = new Process(6, 3, 3);
		Process f = new Process(6, 8, 2);
		Process g = new Process(6, 6, 6);
		Process h = new Process(6, 2, 3);
		Process i = new Process(6, 9, 4);
		Process j = new Process(6, 4, 1);
		Process[] processes = {a, b, c, d, e, f, g, h, i, j};
		list.buildMaxHeap(processes);
		list.print();
		Process result = list.heapMaximum();
		Process expectedResult = j;
		System.out.println(result.toString());
		System.out.println(expectedResult.toString());
		if (result.compareTo(expectedResult) == 0) {
			return true;
		} else {
			return false;
		}	
	}

}
