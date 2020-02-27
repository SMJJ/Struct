package com.liaomj.LinkedList;

public class LinkedListStack<E> implements Stack<E> {
	private LinkedList<E> list;
	
	public LinkedListStack() {
		list = new LinkedList<>();
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return list.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}
	
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		list.addFirst(e);
	}
	
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}
	
	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return list.getFirst();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
	}
}
