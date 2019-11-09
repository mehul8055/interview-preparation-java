package com.mehul.datastructure;

/**
 * @author Mehul
 *
 */
public class SinglyLinkedList {

	private Node head;

	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.append(12);
		linkedList.append(13);
		linkedList.append(2);
		linkedList.append(17);
				
		linkedList.printList();
		linkedList.reverse();
		linkedList.printList();
	}

	public void printList() {
		Node current = head;
		while(current != null) {
			System.out.print(current.data + "->");
			current = current.next;
		}
		System.out.println(current);
		System.out.println("\n");
	}
	
	public void append(int value) {
		if (head == null) {
			head = new Node(value);
			return;
		}

		Node current = head;
		// Go to End of position in linked list
		while (current.next != null) {
			current = current.next;
		}
		current.next = new Node(value);
	}

	public void prepend(int value) {
		Node newHead = new Node(value);
		newHead.next = head;
		head = newHead;
	}
	
	public void reverse() {
		Node current = head;
		Node previous = null;
		Node next = null;

		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		head = previous;
	}

	public boolean hasCycle() {
		if(head == null) {
			return true;
		}
		
		Node fast = head.next;
		Node slow = head;
		
		while(fast != null && fast.next != null && slow !=null) {
			if(fast == slow) {
				return true;
			}
			
			fast = fast.next.next;
			slow = slow.next; 
		}
		return false;
	}
	
	public void deleteWithValue(int value) {
		if(head == null) {
			return;
		}
		if(head.data == value) {
			head = head.next;
			return;
		}
		
		Node current = head;
		while(current.next != null) {
			if(current.next.data == value) {
				current.next = current.next.next;
				return;
			}
			current = current.next;
		}
	}
	
	static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
}
