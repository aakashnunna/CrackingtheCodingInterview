package com.aakash.linkedlist;

public class LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	protected void printList() {
		System.out.println();
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	protected void push(int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;

	}

	protected void insertAfterNode(Node prevNode, int data) {

		Node newNode = new Node(data);

		if (prevNode != null) {
			newNode.next = prevNode.next;
			prevNode.next = newNode;
		} else {
			throw new NullPointerException("Previous Node cannot be null");
		}

	}

	/*
	 * Time complexity of append is O(n) where n is the number of nodes in linked
	 * list. Since there is a loop from head to end, the function does O(n) work.
	 * This method can also be optimized to work in O(1) by keeping an extra pointer
	 * to tail of linked list/
	 */
	protected void append(int data) {

		/* Allocate the Node & Put in the data. Set next as null */
		Node newNode = new Node(data);
		newNode.next = null;

		/* If the Linked List is empty, then make the new node as head */
		if (head == null) {
			head = newNode;
		} else {

			/* Else traverse till the last node */
			Node last = head;
			while (last.next != null)
				last = last.next;

			/* Change the next of last node */
			last.next = newNode;
		}

	}

	protected void deleteLinkedList() {
		head = null;
	}

	protected int lengthOfLinkedList() {

		int length = 0;
		Node n = head;

		while (n != null) {
			length++;
			n = n.next;
		}
		System.out.println();
		System.out.println("Length of LinkedList is " + length);
		return length;
	}

	// Finds the first occurrence of Node with given data
	protected void deleteNodeofData(int data) {

		Node temp = head;
		Node previousNode = null;

		if (temp != null && temp.data == data) {
			head = temp.next;
			return;
		}

		while (temp != null && temp.data != data) {
			previousNode = temp;
			temp = temp.next;
		}

		if (temp == null) {
			return;
		}

		previousNode.next = temp.next;
	}

	protected Integer findMiddleNodeofLinkedList() {

		Integer middleNodeData = null;

		Node fast_node = head;
		Node slow_node = head;

		while (fast_node != null && fast_node.next != null) {
			
			fast_node = fast_node.next.next;
			slow_node = slow_node.next;
			
		}
		
		middleNodeData = slow_node.data;
		System.out.println("Middle Node Data "+middleNodeData);

		return middleNodeData;
	}

	public static void main(String args[]) {

		LinkedList linkedList = new LinkedList();

		linkedList.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);

		linkedList.head.next = second;
		second.next = third;

		linkedList.printList();

		linkedList.push(0);

		linkedList.append(5);

		linkedList.printList();

		linkedList.deleteNodeofData(4);

		linkedList.printList();
		linkedList.findMiddleNodeofLinkedList();

		linkedList.insertAfterNode(third, 33);

		linkedList.printList();

		linkedList.lengthOfLinkedList();
		
		linkedList.findMiddleNodeofLinkedList();

	}

}
