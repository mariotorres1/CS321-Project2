
/**
 * Creates a process and implements methods to adjust a process
 * @author Mario Torres
 */
public class Process implements ProcessInterface, Comparable<Process> {
	private int priorityLevel;
	private int timeRemaining;
	private int arrivalTime;
	private int waitingTime;
	
	/**
	 * Constructor, creates a new process
	 * @param priorityLevel - priority of process
	 * @param remainingTime - remaining time the process has
	 * @param arrivalTime - when the process arrived
	 */
	public Process(int priorityLevel, int remainingTime, int arrivalTime) {
		this.priorityLevel = priorityLevel;
		this.timeRemaining = remainingTime;
		this.arrivalTime = arrivalTime;
		this.waitingTime = 0;
	}
	
	/**
	 * Increments process priority by one
	 */
	public void incrementPriority() {
		priorityLevel++;
	}
	
	/**
	 * Returns the priority of the process
	 */
	public int getPriority() {
		return priorityLevel;
	}
	
	/**
	 * Sets the priority level of a process
	 * @param priority - priority level to set process to 
	 */
	public void setPriority(int priority) {
		priorityLevel = priority;
	}
	
	/**
	 * Returns time remaining of process
	 */
	public int getTimeRemaining() {
		if (timeRemaining < 0) {
			timeRemaining = 0;
			return timeRemaining;
		}
		return timeRemaining;
	}
	
	/**
	 * Decrements the time remaining of a process
	 */
	public void decrementTimeRemaining() {
		timeRemaining --;
	}
	
	/**
	 * Checks to see if process has finished
	 * Returns true if process has finished
	 */
	public boolean finished() {
		if (timeRemaining == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns arrival time of process
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * Returns the waiting time of process
	 */
	public int getWaitingTime() {
		return waitingTime;
	}

	/**
	 * Increments the waiting time of a process by one
	 */
	public void incrementWaitingTime() {
		waitingTime ++;

	}

	/**
	 * Resets the waiting time of a process
	 */
	public void resetWaitingTime() {
		waitingTime = 0;

	}

	/**
	 * Compares two processes priority, if equal priority, compares arrival time
	 * @param process - process to compare against
	 */
	public int compareTo(Process process) {
		if (priorityLevel > process.getPriority()) {
			return 1;
		} else if (priorityLevel < process.getPriority()) {
			return -1;
		} else {
			if (this.arrivalTime < process.arrivalTime) {
				return 1;
			} else if (this.arrivalTime > process.arrivalTime) {
				return -1;
			} else {
				return 0;
			}
		}
	}
	
	/**
	 * Prints and returns the process and it's key values
	 * Used to help Test.java 
	 * @return a string of priority level, remaining time and arrival time of a process
	 */
	public String toString() {
		int priorityLevel = this.priorityLevel;
		int remainingTime = this.timeRemaining;
		int arrivalTime = this.arrivalTime;
		return "Priority level = " + priorityLevel + ", remaining time = " + remainingTime + ", arrival time = " + arrivalTime + ".";
	}

}
