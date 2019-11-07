package com.mehul.datastructure;

/**
 * This class is Binary Search tree, which will have below operation 
 * <ul>
 * <li>Create Root Node</li>
 * <li>Insert any value in BST</li>
 * <li>In order traversal</li>
 * <li>Pre order traversal</li>
 * <li>Post order traversal</li>
 * <li>Check whether provided value is present in BST or not</li>
 * </ul>
 * @author Mehul
 *
 */
public class BinarySearchTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.insert(8);
		root.insert(15);
		root.insert(7);
		root.insert(18);
		root.insert(16);
		
		root.printInOrder();
		System.out.println("\n");
		root.printPreOrder();
		System.out.println("\n");
		root.printPostOrder();
		System.out.println("\n");
		
		System.out.println(root.contains(5));
		System.out.println(root.contains(15));
	}
	
	/**
	 * This is an actual tree node class which contains 
	 * Left Node, Right Node and actual data
	 * 
	 * @author Mehul
	 *
	 */
	static class Node{
		private Node left;
		private Node right;
		private int data;
		
		public Node(int data){
			this.data = data;
		}
		
		/**
		 * Adding Node to Binary search tree
		 * 
		 * @param value
		 */
		public void insert(int value){
			if(value <= data) {
				if(left == null) {
					left = new Node(value);
				}else {
					left.insert(value);
				}
			}else {
				if(right == null) {
					right = new Node(value);
				}else {
					right.insert(value);
				}
			}
		}
		
		/**
		 * Printing Binary search tree using In Order 
		 * Meaning Left -> Root -> Right
		 * 
		 */
		public void printInOrder() {
			if(left != null) {
				left.printInOrder();
			}
			System.out.println(data);
			if(right !=null) {
				right.printInOrder();
			}
		}
		
		/**
		 * Printing Binary search tree using In Order 
		 * Meaning Root -> Left -> Right
		 * 
		 */
		public void printPreOrder() {
			System.out.println(data);
			if(left != null) {
				left.printPreOrder();
			}
			if(right !=null) {
				right.printPreOrder();
			}
		}
		
		/**
		 * Printing Binary search tree using In Order 
		 * Meaning Left -> Right -> Root 
		 * 
		 */
		public void printPostOrder() {
			if(left != null) {
				left.printPostOrder();
			}
			if(right !=null) {
				right.printPostOrder();
			}
			System.out.println(data);
		}
		
		/**
		 * It will check whether provided value is there in 
		 * Binary search tree or not 
		 * 
		 * @param value
		 * @return
		 */
		public boolean contains(int value) {
			if(value == data) {
				return true;
			}else if(value <= data) {
				if(left == null) {
					return false;
				}else {
					return left.contains(value);
				}
			}else {
				if(right == null) {
					return false;
				}else {
					return right.contains(value);
				}
			}
		}
	}
}
