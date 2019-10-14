


/*
 * Project #2: Priority-Queue
 * Class: CS321 Fall-2019
 * Date: 09/20/2019
 * 
 * Class that implements a MaxHeap with a Node style implementation, allows for key increase
 * of nodes, removal of nodes, sorting, and finding where in the heap something might be
 * located.
 * 
 * NOTE: there seems to be an issue when running the driver class, CPUScheduler, as I believe
 * the default constructor, WITH NOTHING INSERTED UPON CREATION, doesn't like that heapSize is 0.
 *
 * @author Cole Gilmore
 *
 *
 * @param <T> - generic type of objects stored in the heap
 */
public class MaxHeap<T> {
	//Variables for class operation.
	private HeapNode<T>[] heap;
	private int heapSize;
	private int capacity;
	private final int DEFAULT_CAPACITY = 50;
	
	//Default heap constructor.
	@SuppressWarnings("unchecked")
	public MaxHeap() {
		//Casting the new HeapNode array as you can't create an array of generics.
		heap = (HeapNode<T>[]) new HeapNode[DEFAULT_CAPACITY];
		heapSize = 0;
		capacity = DEFAULT_CAPACITY;
	}
	
	/*Heap constructor that takes in an array of processes/objects, and their key values.
	 *
	 * @param pArray - array of T objects
	 * 		  intArray - array of integer key values
	 */
	
	@SuppressWarnings("unchecked")
	public MaxHeap(T[] pArray, int[] intArray) {
		//This condition check is required to make sure that during tests things don't break when
			//no processes are passed in but this constructor gets called.
		if(pArray.length == 0) {
			capacity = DEFAULT_CAPACITY;
			heapSize = 0;
			heap = (HeapNode<T>[]) new HeapNode[capacity];
		} else {
		heap = (HeapNode<T>[]) new HeapNode[pArray.length];
		heapSize = pArray.length;
		capacity = intArray.length;
		
		//Adding the processes/objects passed through the constructor to the array.
		for(int i = 0; i < pArray.length; i++) {
			heap[i] = new HeapNode<T>(pArray[i], intArray[i]);
			//Sorting the processes/objects based on key value.
				//For whatever reason when I tried to use maxHeapify() here it failed some of the
				//extractHeapMax() and heapMax() tests.
			if(i >= 2) {
				int current = i;
				while(heap[current].getKey() > heap[parent(current)].getKey()) {
					if(heap[current].getKey() < heap[current-1].getKey()) {
						moveUp(current-1);
						current = parent(current);
					} else {
					moveUp(current);
					current = parent(current);
					}
				}	
			}
		}
		}
	}
	
	/*Returns max key value in heap, i.e. object/process at the top of the heap.
	 *
	 * @return object of type T, or null reference
	 */
	public T heapMax() {
		return heap[0].getObject();
	}
	
	/*Returns and removes max key value in heap.
	 *
	 * @return object of type T, or null reference
	 *
	 */
	public T extractHeapMax() {
		//Base cases to prevent an issue with maxHeapify()
		if(heapSize == 0) {
			return null;
		} if(heapSize == 1) {
			HeapNode<T> pop = heap[0];
			heap[0] = null;
			heapSize--;
			return pop.getObject();
		} else {

		HeapNode<T> pop = heap[0];
		heap[0] = heap[--heapSize];
		maxHeapify(0);
		return pop.getObject();
		}
	}

	/* Increases the key value for the object/process at the given location.
	 *
	 * @param i, i2 - integer values, one for the desired object to use, and the
	 * 					second integer value being what key value to assign.
	 */
	public void increaseHeapKey(int i, int i2) {
		if(heapSize == 0 || i > heapSize) {
			return;
		}
		int temp = i-1;
		heap[temp].setKey(i2);
		//Promoting the object/process as maxHeapify doesn't like when a node is a leaf.
		moveUp(temp);
		maxHeapify(parent(parent(temp)));
	}
	
	/* Inserting a new object/process into the heap array 
	 *
	 *	@param process - object of type T,
	 *			i - integer value to assign key value
	 */
	public void maxHeapInsert(T process, int i) {
		if(heapSize == capacity) {
			expandCapacity();
		}
		HeapNode<T> temp = new HeapNode<T>(process, i);
		heap[heapSize] = temp;
		maxHeapify(parent(heapSize)); //fixing the ordering to maintain a maxHeap
		heapSize++;
	}
	
	
	/* Increasing the array size if capacity of the heap has been reached
	 */
	@SuppressWarnings("unchecked")
	private void expandCapacity() {
		capacity = capacity*2;
		//Creating a temporary array to store the current array's objects and then creating a new, larger, array
			//to put the objects back into.
		HeapNode<T>[] tempArray = (HeapNode<T>[]) new HeapNode[heapSize];
		for(int i = 0; i < heapSize; i++) {
			tempArray[i] = heap[i];
		}
		heap = (HeapNode<T>[]) new HeapNode[capacity];
		for(int i = 0; i < tempArray.length; i++) {
			heap[i] = tempArray[i];
		}
	}
	
	/* Ordering the processes/objects in the array based on key values.
	 *
	 * @param i - integer index on where to start the ordering process from
	 */
	public void maxHeapify(int i) {
		if(heapSize == 0 || heapSize == 1) {
			return;
		}
		int l = left(i);
		int r = right(i);
		int largest;
		if(l <= heapSize && heap[l].getKey() > heap[i].getKey()) {
			largest = l;
		} else {
			largest = i;
		} if(r <= heapSize && heap[r].getKey() > heap[largest].getKey()) {
			largest = r;
		} if(largest != i) {
			exchange(i, largest);
			maxHeapify(parent(parent(largest)));
		}
	}
	
	/* Moving the object at the given index to the parent node/root.
	 *
	 * @param i - integer value of what node to move up in the array
	 */
	private void moveUp(int i) {
		exchange(i, parent(i));
	}
	
	//Returns size of the heap.
	public int getHeapSize() {
		return heapSize;
	}
	
	//Returns boolean value on whether there is anything in the array or not
	public boolean isEmpty() {
		return heapSize == 0;
	}
	
	/* Swaps the two HeapNodes in the array
	 * 
	 * @param i, i2 - integer index values of nodes in the array
	 */
	private void exchange(int i, int i2) {
		HeapNode<T> temp;
		temp = heap[i];
		heap[i] = heap[i2];
		heap[i2] = temp;
	}
	
	/* Calculates the index of the left 'child' in the heap from a given index.
	 * 
	 * @param i - integer index value
	 * @return  integer value
	 */
	private int left(int i) {
		return (i*2)+1;
	}
	
	/* Calculates the index of the right 'child' in the heap from a given index.
	 * 
	 * @param i - integer index value
	 * @return  integer value
	 */
	private int right(int i) {
		return (i*2)+2;
	}
	
	/* Calculates the index of the 'parent/root' of a given index in the heap
	 * 
	 * @param i - integer index value
	 * @return  integer value
	 */
	private int parent(int i) {
		return (i-1)/2;
	}
	
	/* Setter for heapSize of the heap
	 * 
	 * @param i - integer value to set the heapSize
	 */
	private void setHeapSize(int i) {
		heapSize = i;
	}
	
	/* Setter for capacity of the heap
	 * 
	 * @param i - integer value to set the heap capacity
	 */
	private void setCapacity(int i) {
		capacity = i;
	}
}
