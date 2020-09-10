package io.gonzajf.leetCode.linkedList;

public class MyLinkedList {

	private static class Node {
		int data;
		private Node previous;
		private Node next;

		public Node(int data, Node previous, Node next) {
			this.data = data;
			this.previous = previous;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;

	int size = 0;

	/** Initialize your data structure here. */
	public MyLinkedList() {
		head = new Node(-1, null, null);
		tail = new Node(-1, head, null);
		head.next = tail;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		return getNodeAt(index).data;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		addBetween(val, head, head.next);
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		addBetween(val, tail.previous, tail);
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index == size)
			addBetween(val, tail.previous, tail);
		else if (inRange(index)) {
			Node node = getNodeAt(index);
			addBetween(val, node.previous, node);
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (inRange(index))
			remove(getNodeAt(index));
	}

	private void addBetween(int data, Node previous, Node next) {
		Node node = new Node(data, previous, next);
		previous.next = node;
		next.previous = node;
		size++;
	}

	public boolean inRange(int index) {
		return (index >= 0 && index < size);
	}

	private void remove(Node node) {
		Node prev = node.previous;
		Node next = node.next;

		prev.next = next;
		next.previous = prev;

		size--;
	}

	private Node getNodeAt(int index) {
		if (head.next == null)
			return null;

		Node temp = head.next;

		while (index > 0) {
			temp = temp.next;
			index--;
		}
		return temp;
	}
}