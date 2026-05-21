package w3.linkedlist;

import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public LinkedListUtil.ListNode removeNthFromEnd(LinkedListUtil.ListNode head, int n) {
        LinkedListUtil.ListNode slow = head;
        LinkedListUtil.ListNode fast = head;

        while (n-- > 0){
            fast = fast.next;
        }

        if(fast == null) return head.next;

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    public static void main(String[] args) {

        LinkedListUtil linkedListUtil = new LinkedListUtil();
        LinkedListUtil.ListNode head = linkedListUtil.createLinkedList(5);
        LinkedListUtil.ListNode head1 = linkedListUtil.createLinkedList(1);

        RemoveNthNodeFromEndOfList obj = new RemoveNthNodeFromEndOfList();
        linkedListUtil.printList(head);
        head = obj.removeNthFromEnd(head,1);
        linkedListUtil.printList(head);

        linkedListUtil.printList(head1);
        head1 = obj.removeNthFromEnd(head1,1);
        linkedListUtil.printList(head1);
    }
}


/*
 *
 * Approach: The algorithm starts by advancing the fast pointer forward $B$ steps while keeping the slow pointer at the head.
 *           This establishes a exact physical buffer zone of length $N$ between the two trackers. If the fast pointer hits null
 *           immediately after moving forward $B$ steps, it means $N$ is exactly equal to the length of the list. In other words,
 *           you are being asked to remove the very first node (the head). The code cleanly handles this in a single line by returning head.next.
 *           If it's not the head, the code enters a second loop where both slow and fast move forward at the exact same pace of one node per iteration.
 *           Because the gap between them remains locked at $N$, the moment fast reaches the absolute last node (fast.next == null), slow is guaranteed to be parked exactly one node before the target deletion node.
 *           It bridges over the target node with slow.next = slow.next.next, instantly snipping it out of the list structure.
 *
 *
 * TC: O(N) Let N be the number of nodes in list.
 * SC: O(1)
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 */