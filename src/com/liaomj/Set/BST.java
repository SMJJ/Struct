package com.liaomj.Set;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
	private class Node{
		public E e;
		public Node left,right;
		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	private int size;
	public BST() {
		root = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void add(E e) {
		root = add(root, e);
	}
	
	private Node add(Node node,E e) {
		if(node == null) {
			size ++;
			return new Node(e);
		}
		
		if(e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		}else if(e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		}	
		return node;	
	}
	
	public boolean contains(E e) {
		return contains(root,e);
	}
	
	private boolean contains(Node node,E e) {
		if(node == null) {
			return false;
		}
		
		if(e.compareTo(node.e) == 0) {
			return true;
		}else if(e.compareTo(node.e) < 0){
			return contains(node.left,e);
		}else {
			return contains(node.right,e);
		}
	}

	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		if(node == null)
			return;
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder() {
		preOrder(root);
	}
	
	private void inOrder(Node node) {
		if(node == null)
			return;
		
		preOrder(node.left);
		System.out.println(node.e);
		preOrder(node.right);
	}
	
	public void postOrder() {
		preOrder(root);
	}
	
	private void postOrder(Node node) {
		if(node == null)
			return;
		
		preOrder(node.left);
		preOrder(node.right);
		System.out.println(node.e);
	}
	
	public void levelOrder() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node curNode = q.remove();
			System.out.print(curNode.e);
			
			if(curNode.left != null)
				q.add(curNode.left);
			if(curNode.right != null)
				q.add(curNode.right);
		}
	}
	
	public E minimum() {
		if(size == 0)
			throw new IllegalArgumentException("BST is empty");
		Node minNode = minimum(root);
		return minNode.e;
	}
	
	private Node minimum(Node node) {
		if(node.left == null)
			return node;
		return minimum(node.left);
	}
	
	public E removeMin() {
		E retE = minimum();
		root = removeMin(root);
		return retE;
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
	
	public E maxmum() {
		if(size == 0)
			throw new IllegalArgumentException("BST is empty");
		Node maxNode = maxmum(root);
		return maxNode.e;
	}
	
	private Node maxmum(Node node) {
		if(node.left == null)
			return node;
		return maxmum(node.right);
	}
	
	public E removeMax() {
		E retE = maxmum();
		root = removeMax(root);
		return retE;
	}
	
	private Node removeMax(Node node) {
		if(node.right == null) {
			Node leftNode = node.left;
			node.left = null;
			size --;
			return leftNode;
		}
		
		node.right = removeMax(node.right);
		return node;
	}
	
	public void remove(E e) {
		root = remove(root,e);
	}
	
	private Node remove(Node node,E e) {
		if(node == null)
			return null;
		
		if(e.compareTo(node.e)<0) {
			node.left = remove(node.left, e);
			return node;
		}
		else if(e.compareTo(node.e)>0) {
			node.right = remove(node.right, e);
			return node;
		}
		else { // e.compareTo(node.e) == 0
			if(node.left == null) {
				Node righNode = node.right;
				node.right = null;
				size --;
				return righNode;
			}
			
			if(node.right == null) {
				Node lefNode = node.left;
				node.left = null;
				size --;
				return lefNode;
			}
			
			Node successor = new Node(minimum(node.right).e);
			size++;
			
			successor.right = removeMin(node.right);
			successor.left = node.left;
			node.left=node.right=null;
			size--;
			
			return successor;
		}
	}
	
		
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
        return res.toString();
	}
	
	private void generateBSTString(Node node,int depth,StringBuilder res) {
		
	}
	
}
