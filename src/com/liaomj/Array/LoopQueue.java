package com.liaomj.Array;

public class LoopQueue<E> implements Queue<E>{
	private E[] data;
	private int front,tail;
	private int size;
	
	public LoopQueue(int capacity) {
		// TODO Auto-generated constructor stub
		data = (E[])new Object[capacity+1];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	public LoopQueue() {
		// TODO Auto-generated constructor stub
		this(10);
	}
	
	public int getCapacity() {
		return data.length-1;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front==tail;
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity];
		for(int i=0;i<size;i++) {
			newData[i] = data[(i+front)%data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}
	
	@Override
	public void enqueue(E e) {
		// TODO Auto-generated method stub
		if((tail+1)%data.length == front) {
			resize(getCapacity()*2);
		}
		data[tail] = e;
		tail = (tail+1)%data.length;
		size++;
	}
	
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
		E ret = data[front];
		data[front] = null;
		front = (front+1)%data.length;
		size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
		return ret;
	}
	
    @Override
    public E getFront(){
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }
    
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
