package com.aakash.linkedlist;

//A simple Java program to introduce a linked list. 

public class LinkedListBasic {
	
	Node head; // head of the list
	
	/* Linked list Node.  This inner class is made static so that
    main() can access it */
	static class Node {
		int data;
		Node next;
		
		// Constructor
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	public void printList() {
		
		Node n = head;
		while(n != null) {
			System.out.print(n.data+" ");
			n = n.next;
		}
		
	}
	
	public static void main(String args[]) {
		
		LinkedListBasic linkedList = new LinkedListBasic();
		
		linkedList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		linkedList.head.next = second;
		second.next = third;
		
		linkedList.printList();
		
	}

}
