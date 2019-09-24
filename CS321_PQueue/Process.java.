package HeapQueue;
/*
 * Basic process simulation class for ProcessGenerator and CPUScheduler
 * 
 * @author Cole Gilmore
 */
public class Process {
	private int priorityLevel, timeToFinish, timeNotProcessed, arrivalTime, maxPriorityLevel;

	/*
	 * Constructor for creating a new process/object to be stored in the heap/queue
	 * 
	 * @param i - integer value for the time the process/object was made
	 * 			i2 - integer value for the priority level of the new process
	 * 			i3 - estimated time until the new process will be completed
	 * 			i4 - maximum possible priority level for the new process
	 */
	public Process(int i, int i2, int i3, int i4) {
		arrivalTime = i;
		priorityLevel = i2;
		timeToFinish = i3;
		maxPriorityLevel = i4;
	}
	
	/*
	 * Decreases the value of the process's estimated finish time
	 */
	public void reduceTimeRemaining() {
		timeToFinish--;	
	}
	
	/*
	 * Increases the value of the process's time being left alone
	 */
	public void incrementTimeNotProcessed() {
		timeNotProcessed++;
	}
	
	/*
	 * Returns the integer value for the length of time a process has been left alone
	 * 
	 * @return timeNotProcessed - non-negative integer value
	 */
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
	
	/*
	 * Returns the integer value for the length of time until a process is finished
	 * 
	 * @return timeToFinish - non-negative integer value
	 */
	public int getTimeRemaining() {
		return timeToFinish;
	}
	
	/*
	 * Returns a boolean value for whether a process has been finished or not
	 * 
	 * @return boolean value
	 */
	public boolean done() {
		return timeToFinish == 0;
	}
	
	/*
	 * Returns the integer value of when a process was added to the queue 
	 *
	 * @return arrivalTime - non-negative integer value
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}

	/*
	 * Returns the priority level assigned to a process
	 * 
	 * @return priorityLevel - non-negative integer value
	 */
	public int getPriority() {
		return priorityLevel;
	}

	/*
	 * Increments a processes' priority level
	 */
	public void incrementPriority() {
		priorityLevel++;
	}

	/*
	 * Resets the time that a process has been left alone for
	 */
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;
	}
	
	/*
	 * Sets the priority level for a process
	 * 
	 * @param i - non-negative integer value
	 */
	private void setPriorityLevel(int i) {
		priorityLevel = i;
	}
	
	/*
	 * Returns the time until a process has been completed
	 * 
	 * @return timeToFinish - non-negative integer value
	 */
	public int getTimeToFinish() {
		return timeToFinish;
	}
	
	/*
	 * Sets the time until a process is finished
	 * 
	 * @param i - non-negative integer value 
	 */
	private void setTimeToFinish(int i) {
		timeToFinish = i;
	}
	
	/*
	 * Sets the time that a process has been left alone
	 * 
	 * @param i - non-negative integer value
	 */
	private void setTimeNotProcessed(int i) {
		timeNotProcessed = i;
	}
	
	/*
	 * Sets the time that a process was added to the queue/heap
	 *
	 * @param i - integer value
	 */
	private void setArrivalTime(int i) {
		arrivalTime = i;
	}
	
	/*
	 * Returns the maximum priority level for a process
	 * 
	 * @return maxPriorityLevel - integer value
	 */
	public int getMaxPriorityLevel() {
		return maxPriorityLevel;
	}
	
	/*
	 * Sets the maximum priority level for a process
	 * 
	 * @param i -  non-negative integer value
	 */
	public void setMaxPriorityLevel(int i) {
		maxPriorityLevel = i;
	}
}
