package com.liaomj.Map;

public class LinkedListMap<K,V> implements Map<K, V> {
	private class Node{
		public K key;
		public V value;
		public Node next;
		
		public Node(K key,V value,Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		
		public Node(K key,V value) {
			this(key, value, null);
		}
		
		public Node() {
			this(null, null,null);
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return key.toString()+":"+value.toString();
		}
	}
	
	private Node dummyHead;
	private int size;
	
	public LinkedListMap() {
		dummyHead = new Node();
		size = 0;
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}
	
	private Node getNode(K key) {
		Node cur = dummyHead.next;
		while (cur != null) {
			if(cur.key.equals(key))
				return cur;
			cur = cur.next;
		}
		return null;
	}
	
	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return getNode(key) != null;
	}
	
	@Override
	public V get(K key) {
		Node node = getNode(key);
		return node == null ? null : node.value;
	}
	
	@Override
	public void add(K key, V value) {
		Node node = getNode(key);
		if(node == null) {
			dummyHead.next = new Node(key,value,dummyHead.next);
			size++;
		}else {
			node.value = value;
		}
	}
	
	@Override
	public void set(K key, V newValue) {
		Node node = getNode(key);
		if(node == null)
			throw new IllegalArgumentException(key + " doesn't exist!");
		node.value = newValue;
	}
	
	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		Node prevNode = dummyHead;
		while(prevNode.next != null) {
			if(prevNode.next.key.equals(key))
				break;
			prevNode = prevNode.next;
		}
		if(prevNode.next != null) {
			Node delNode = prevNode.next;
			prevNode.next = delNode.next;
			delNode.next = null;
			size --;
			return delNode.value;
		}
		return null;
	}
}
