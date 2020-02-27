package com.liaomj.Array;

public class ArrayQueue<E> implements Queue<E> {
	private Array<E> array;
	
	public ArrayQueue(int capacity){
		array = new Array<E>(capacity);
	}
	
	public ArrayQueue() {
		array = new Array<E>();
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return array.getSize();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return array.isEmpty();
	}
	
	public int getCapacity() {
		return array.getCapacity();
	}
	
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		array.addLast(e);
	}
	
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		return array.removeFirst();
	}
	
	@Override
	public E getFront() {
		// TODO Auto-generated method stub
		return array.getFirst();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
	}
}
