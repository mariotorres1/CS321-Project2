
/**
 * Represents a Priority Queue using a MaxHeap
 * @author Mario Torres
 */

public class MyPriorityQueue extends MaxHeap implements PriorityQueueInterface {

	private MaxHeap priorityQueue;
	
	/**
	 * Constructor, initializes a priority queue using a MaxHeap
	 */
	public MyPriorityQueue(){
		priorityQueue = new MaxHeap();
	}
	
	
	/**
	 * Adds a process to the priority queue
	 * @param process - process to be added to priority queue
	 */
	public void enqueue(Process process){
		priorityQueue.maxHeapInsert(process);
	}
	
	/**
	 * Removes and returns the highest priority process from the queue
	 */
	public Process dequeue(){
		return priorityQueue.maxHeapExtract();
	}
	
	/**
	 * updates each process in the priority queue and adjusts based on waitingTime, and priority
	 * @param timeToIncrementPriority - time before process is adjusted
	 * @param maxLevel - max priority level
	 */
	public void update(Process next, int timeToIncrementPriority, int maxPriority) {		
		for (int i = 0; i < priorityQueue.size(); i++) {
			Process currentProcess = priorityQueue.getHeapArray()[i];
			currentProcess.incrementWaitingTime();
			if (currentProcess.getWaitingTime() >= timeToIncrementPriority) {
				currentProcess.resetWaitingTime();
				if (currentProcess.getPriority() < maxPriority) {
					currentProcess.incrementPriority();
					priorityQueue.maxHeapifyUp(i);
				}
			}
		}

	}
	
	/**
	 * Checks to see if the priority queue is empty
	 * @return true if empty
	 */
	public boolean isEmpty() {

		boolean retVal = false;

		if(priorityQueue.size() == 0){
			retVal = true;
		}

		return retVal;
	}

}