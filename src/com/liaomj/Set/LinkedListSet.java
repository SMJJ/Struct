package com.liaomj.Set;

public class LinkedListSet<E> implements Set<E> {
	private LinkedList<E> list;
	
	public LinkedListSet() {
		list = new LinkedList<E>();
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
	public void add(E e) {
		if(!list.contains(e))
			list.addFirst(e);
	}
	
	@Override
	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return list.contains(e);
	}
	
	@Override
	public void remove(E e) {
		list.removeElement(e);
	}
}
