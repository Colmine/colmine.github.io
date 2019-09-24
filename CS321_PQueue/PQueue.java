package HeapQueue;
/* 
 * Priority Queue class for MaxHeap and CPUScheduler
 * Uses the MaxHeap class as a go-between for Process and ProcessGenerator and CPUScheduler
 * 
 * @author Cole Gilmore
 * @param <T> - generic type of objects stored in the queue
 */
public class PQueue<T> {
	private MaxHeap<T> maxHeap;

	//Default constructor
	PQueue(){
		maxHeap = new MaxHeap<T>();
	}
	
	//Constructor that takes in an array of generic objects and their associated key values
	//@param pArray - generic array of objects
	//			intArray - array of integer key values
	PQueue(T[] pArray, int[] intArray){
		maxHeap = new MaxHeap<T>(pArray, intArray);
	}
	
	/*
	 * Returns the maximum value in the queue
	 * 
	 * @return T - object of type T, or null reference
	 */
	public T maximum() {
		return maxHeap.heapMax();
	}

	/*
	 * Returns and removes the maximum value in the queue
	 * 
	 * @return T - object of type T, or null reference
	 */
	public T extractMax() {
		return maxHeap.extractHeapMax();
	}

	/*
	 * Increase key value for given object/index in the queue
	 * 
	 * @param i - integer value for the index of the object,
	 * 			i2 - integer value for the desired key value
	 */
	public void increaseKey(int i, int i2) {
		maxHeap.increaseHeapKey(i, i2);
	}
	
	/*
	 * Insert object/process into the queue/heap
	 * 
	 * @param process - generic object of type T,
	 * 			priority - integer key value for the new process/object
	 */
	public void insert(T process, int priority) {
		maxHeap.maxHeapInsert(process, priority);
	}

	/*
	 * Boolean value/check to see if the queue/heap is empty
	 * 
	 * @return boolean value - true, or false
	 */
	public boolean isEmpty() {
		return maxHeap.isEmpty();
	}
	
	/*
	 * Checks the size/number of tasks/objects in the queue/heap
	 * 
	 * @return integer value
	 */
	public int size() {
		return maxHeap.getHeapSize();
	}

}
