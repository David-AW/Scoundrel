package com.davidaw.scoundrel;
public class ArrayQueue<T> {

	private Object[] storage;
	
	private int start = 0;
	private int next = 0;
	
	public ArrayQueue() {
		this(16);
	}
	
	public ArrayQueue(int queue_size) {
		storage = new Object[queue_size];
	}
	
	public boolean enqueue(T e) {
		if (isFull())
			return false;
		storage[next++ % storage.length] = e;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public T dequeue() {
		if (isEmpty())
			return null;
		T temp = (T) storage[start++];
		// This is to avoid the inevitable possibility of running out of bits in the integer
		if (start >= storage.length) {
			next -= start;
			start = 0;
		}
		return temp;
	}

	public boolean swap(int from_index, int to_index) {
		int normalized_next = next - start;
		if (from_index < 0 || from_index >= to_index || to_index >= normalized_next)
			return false;
		int actual_from = (from_index + start) % storage.length;
		int actual_to = (to_index + start) % storage.length;
		Object temp = storage[actual_to];
		storage[actual_to] = storage[actual_from];
		storage[actual_from] = temp;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) throws IndexOutOfBoundsException {
		int normalized_next = next - start;
		if (index < 0 || index >= normalized_next)
			throw new IndexOutOfBoundsException(index);
		int actual_index = (index + start) % storage.length;
		return (T) storage[actual_index];
	}
	
	public void fill(T[] list) {
		for(T item : list) {
			if (isFull())
				break;
			enqueue(item);
		}
	}
	
	public void clear() {
		start = 0;
		next = 0;
	}

	public boolean isEmpty() {
		return start == next;
	}

	public boolean isFull() {
		return size() >= storage.length;
	}

	public int size() {
		return next-start;
	}
	
	public int maxSize() {
		return storage.length;
	}
	
	public Object[] toArray() {
		Object[] temp = new Object[size()];
		for (int i = 0; i < temp.length; i++)
			temp[i] = get(i);
		return (Object[]) temp;
	}
 
	public String toString(String delimiter) {
		String temp = "";
		for (int i = start; i < next; i++) {
			temp += storage[i%storage.length].toString();
			if (i < next-1)
				temp += delimiter;
		}
		return temp;
	}
	
	@Override
	public String toString() {
		return toString("");
	}
	
}