package com.liaomj.Set;

public class BSTSet<E extends Comparable<E>> implements Set<E> {
	private BST<E> bst;
	
	public BSTSet() {
		bst = new BST<>();
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return bst.size();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return bst.isEmpty();
	}
	
	@Override
	public void add(E e) {
		bst.add(e);
	}
	
	@Override
	public void remove(E e) {
		bst.remove(e);
	}
	
	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}
	
}
