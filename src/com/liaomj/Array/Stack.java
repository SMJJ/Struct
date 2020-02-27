package com.liaomj.Array;

public interface Stack<E> {
	int getSize();
	boolean isEmpty();
	void push(E e);
	E pop();
	E peek();
}
