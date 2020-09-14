package io.gonzajf.leetCode.linkedList;

public class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	/**
	 * Given head, the head of a linked list, determine if the linked list has a
	 * cycle in it. There is a cycle in a linked list if there is some node in the
	 * list that can be reached again by continuously following the next pointer.
	 * Internally, pos is used to denote the index of the node that tail's next
	 * pointer is connected to. Note that pos is not passed as a parameter. Return
	 * true if there is a cycle in the linked list. Otherwise, return false.
	 */
	public static boolean hasCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Given a linked list, return the node where the cycle begins. If there is no
	 * cycle, return null. To represent a cycle in the given linked list, we use an
	 * integer pos which represents the position (0-indexed) in the linked list
	 * where tail connects to. If pos is -1, then there is no cycle in the linked
	 * list.
	 */
	public static ListNode detectCycle(ListNode head) {

		// base case to avoid null pointer exception
		if (head == null || head.next == null) {
			return null;
		}

		// Step 1: Find if there exist a cycle
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {

			if (fast == null || fast.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		// Step 2: Find where the cycle is
		ListNode slow2 = head;
		slow = slow.next;
		while (slow != slow2) {
			slow = slow.next;
			slow2 = slow2.next;
		}
		return slow;
	}

	/**
	 * Write a program to find the node at which the intersection of two singly
	 * linked lists begins.
	 */
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) {
			return null;
		}

		ListNode p1 = headA;
		ListNode p2 = headB;

		while (p1 != p2) {

			p1 = p1.next;
			p2 = p2.next;

			if (p1 == p2) {
				return p1;
			}

			if (p1 == null) {
				p1 = headB;
			}

			if (p2 == null) {
				p2 = headA;
			}
		}
		return p1;
	}

	/**
	 * Given a linked list, remove the n-th node from the end of list and return its head.
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		// Advances first pointer so that the gap between first and second is n nodes
		// apart
		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}
		// Move first to the end, maintaining the gap
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}
}