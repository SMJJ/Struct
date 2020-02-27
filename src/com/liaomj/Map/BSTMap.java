package com.liaomj.Map;

import java.util.PrimitiveIterator.OfDouble;

import javax.jws.WebParam.Mode;

public class BSTMap<K extends Comparable<K>,V> implements Map<K, V> {
	private class Node{
		public K key;
		public V value;
		public Node left,right;
		
		public Node(K key,V value) {
			this.key = key;
			this.value = value;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	private int size;
	public BSTMap() {
		root = null;
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
	
	@Override
	public void add(K key,V value) {
		root = add(root, key, value);
	}
	
	private Node add(Node node,K key,V value) {
		if(node == null) {
			size ++;
			return new Node(key, value);
		}
		
		if(key.compareTo(node.key)<0)
			node.left = add(node.left, key, value);
		else if (key.compareTo(node.key)>0) 
			node.right = add(node.right, key, value);
		else 
			node.value = value;
		
		return node;
	}
	
	public Node getNode(Node node,K key) {
		if(node == null)
			return null;
		
		if(key.equals(node.key))
			return node;
		else if(key.compareTo(node.key)<0)
			return getNode(node.left, key);
		else 
			return getNode(node.right, key);
	}
	
	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return getNode(root, key) != null;
	}
	
	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		Node node = getNode(root, key);
		return node == null ? null : node.value;
	}
	
	@Override
	public void set(K key, V newValue) {
		// TODO Auto-generated method stub
		Node node = getNode(root, key);
		if(node == null)
			throw new IllegalArgumentException(key + " doesn't exist!");
		node.value = newValue;
	}
	
	private Node minimum(Node node) {
		if(node.left == null)
			return node;
		return minimum(node.left);
	}
	
	private Node removeMin(Node node) {
		if(node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size --;
			return rightNode;
		}
		
		node.left = removeMin(node.left);
		return node;
	}
	
	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		Node node = getNode(root, key);
		if(node != null) {
			root = remove(root,key);
			return node.value;
		}
		return null;
	}
	
	private Node remove(Node node,K key) {
		if(node == null)
			return null;
		if(key.compareTo(node.key)<0) {
			node.left = remove(node.left, key);
			return node;
		}else if(key.compareTo(node.key)>0){
			node.right = remove(node.right, key);
			return node;
		}else {
			if(node.left == null) {
				Node rigNode = node.right;
				node.right = null;
				size --;
				return rigNode;
			}
			if(node.right == null) {
				Node leftNode = node.left;
				node.left = null;
				size --;
				return leftNode;
			}
			
			Node successNode = minimum(node.right);
			successNode.right = removeMin(node.right);
			successNode.left = node.left;
			return successNode;
		}
	}
	
}
