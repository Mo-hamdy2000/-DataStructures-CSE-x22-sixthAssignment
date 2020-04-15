package Classes;

import Interfaces.IArrayBased;
import Interfaces.IQueue;

public class QueueArrayBased implements IQueue, IArrayBased {
	
	Object[] Queue;
	int f, r, capacity;
	
	// The constructor takes the queue size and instantiate array with the specified size
	public QueueArrayBased(int cap) {
		capacity = cap + 1;
		Queue = new Object[capacity];
		f = r = 0;
	}
	
	// Enqueue object in rear index then advance rear
	@Override
	public void enqueue(Object item) {
		if (size() == capacity - 1) {
			throw new IllegalStateException();
		}
		Queue[r] = item;
		r = (r + 1) % capacity;
	}

	// Dequeue by taking the element in the front index and then advance it
	@Override
	public Object dequeue() {
		if(this.isEmpty()) {
			throw new IllegalStateException();
		}
		Object temp = Queue[f];
		Queue[f] = null;
		f = (f + 1) % capacity;
		return temp;
	}

	// Check if the queue is empty when rear and front are equal
	@Override 
	public boolean isEmpty() {
		return f == r;
	}

	// Get the number of elements in the queue
	@Override
	public int size() {
		return (capacity - f + r) % capacity;
	}
	
	
	public boolean isFull() {
		return (capacity - f + r) % capacity == capacity - 1;
	}

}
