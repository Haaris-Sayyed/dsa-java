package w3.linkedlist;

public class LinkedListCycle {

    public boolean hasCycle(LinkedListUtil.ListNode head) {
       LinkedListUtil.ListNode slow = head;
       LinkedListUtil.ListNode fast = head;

       while (fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
           if(slow == fast) return true;
       }
       return false;
    }

    public static void main(String[] args) {

        LinkedListUtil.ListNode head = new LinkedListUtil.ListNode(3);
        LinkedListUtil.ListNode node = head;
        node.next = new LinkedListUtil.ListNode(2);
        node.next.next = new LinkedListUtil.ListNode(0);
        node.next.next.next = new LinkedListUtil.ListNode(-4);
        node.next.next.next.next = head.next;

        LinkedListCycle obj = new LinkedListCycle();
        System.out.println(obj.hasCycle(head));

    }

}

/*
 *
 * Approach: This code implements Floyd’s Cycle-Finding Algorithm (frequently called the "Tortoise and the Hare" algorithm)
 *           to detect if a linked list contains a loop. The Strategy: It initializes two pointers at the head of the list: a slow pointer
 *           that steps forward one node at a time, and a fast pointer that leaps forward two nodes at a time.
 *           The Mechanics: If the list is linear and has an end, the fast pointer will inevitably hit null (or its next will be null), terminating the loop and returning false.
 *           However, if a cycle exists, the list becomes infinite. Once both pointers enter the loop, the fast pointer closes the distance between itself and the slow pointer by exactly one node per iteration.
 *           Because of this relative speed, the fast pointer is mathematically guaranteed to catch up and collide with the
 *           slow pointer (slow == fast), immediately confirming a cycle and returning true.
 *
 * TC : O(N)  Let N be the total number of nodes in the linked list.
 * SC: O(1)
 *
 * Input: nums = [3,2,0,-4] pos = 1
 * Output: true
 */
