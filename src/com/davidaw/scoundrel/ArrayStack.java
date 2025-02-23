package com.davidaw.scoundrel;

public class ArrayStack<T> {

	Object[] storage;
	int next = 0;

	public ArrayStack() {
		this(16);
	}

	public ArrayStack(int stack_size) {
		storage = new Object[stack_size];
	}

	public boolean push(T e) {
		if (isFull())
			return false;
		storage[next++] = e;
		return true;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		if (isEmpty())
			return null;
		return (T) storage[--next];
	}

	public void fill(T[] list) {
		for (T item : list) {
			if (isFull())
				break;
			push(item);
		}
	}

	public boolean isEmpty() {
		return next <= 0;
	}

	public boolean isFull() {
		return next >= storage.length;
	}

	@SuppressWarnings("unchecked")
	public T top() {
		if (isEmpty())
			return null;
		return (T) storage[next-1];
	}

	public int size() {
		return next;
	}

	public String toString(String delimiter) {
		String temp = "";
		for (int i = 0; i < next; i++) {
			temp += storage[i].toString();
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
