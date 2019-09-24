package HeapQueue;
/*
 * Go-between class for Process, PQueue, and CPUScheduler
 * Generates random numbers and probability to determine when
 * a new process gets added to the queue/heap, and how long it
 * is going to take to finish.
 * 
 * @author Cole Gilmore
 * 
 */

import java.util.Random;

public class ProcessGenerator {
	private double probability;
	private Random random;
	
	/*
	 * Constructor for a random number/process generator
	 *
	 * @param prob - non-negative double value
	 */
	public ProcessGenerator(double prob) {
		probability = prob;
		random = new Random();
	}
	
	/*
	 * Returns a boolean value if a randomly generated double value
	 * is higher or lower than the established probability value.
	 * Determines how often a process should be added to the queue.
	 * 
	 * @return boolean value
	 */
	public boolean query() {
		double temp = random.nextDouble();
		return temp < probability;
	}

	/*
	 * Constructor for a new process to be added to the queue.
	 * Generates two random integer values to determine the length of
	 * time for the process to be completed and its priority level.
	 * 
	 * @param currentTime - non-negative integer value
	 * 			maxProcessTime - non-negative integer value
	 * 			maxLevel - non-negative integer value
	 * 
	 * @return newProcess - Process object to be added to the queue
	 */
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		int timeToFin = (random.nextInt(maxProcessTime));
		int priorityLevel = (random.nextInt(maxLevel));
		Process newProcess = new Process(currentTime, priorityLevel, timeToFin, maxLevel);
		return newProcess;
	}
	
	
	/*
	 * Sets the probability value for the generator.
	 * 
	 * @param prob - non-negative double value, from 0-1
	 * 
	 */
	private void setProbability(double prob) {
		probability = prob;
	}
}
