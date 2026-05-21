package w3.linkedlist;

public class ReorderList {

    public void reorderList(LinkedListUtil.ListNode head) {
        if (head == null || head.next == null)
            return;

         LinkedListUtil.ListNode firstHalfHead = head;
         LinkedListUtil.ListNode secondHalfhead = findMiddle(head);
         secondHalfhead = reverseList(secondHalfhead);

         while (secondHalfhead != null){
             LinkedListUtil.ListNode next = firstHalfHead.next;
             firstHalfHead.next = secondHalfhead;
             firstHalfHead = secondHalfhead;
             secondHalfhead = next;
         }

    }

    public LinkedListUtil.ListNode findMiddle(LinkedListUtil.ListNode head){
        LinkedListUtil.ListNode slow = head;
        LinkedListUtil.ListNode fast = head;
        LinkedListUtil.ListNode prev = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    public LinkedListUtil.ListNode reverseList(LinkedListUtil.ListNode head){
        LinkedListUtil.ListNode prev = null;
        LinkedListUtil.ListNode curr = head;

        while (curr != null){
            LinkedListUtil.ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }



    public static void main(String[] args) {
        LinkedListUtil linkedListUtil = new LinkedListUtil();
        LinkedListUtil.ListNode head = linkedListUtil.createLinkedList(4);

        ReorderList obj = new ReorderList();
        linkedListUtil.printList(head);
        obj.reorderList(head);
        linkedListUtil.printList(head);

        LinkedListUtil.ListNode head1 = linkedListUtil.createLinkedList(1);
        linkedListUtil.printList(head1);
        obj.reorderList(head1);
        linkedListUtil.printList(head1);
    }
}

/*
 *
 * Approach: It uses a classic fast-and-slow pointer technique to locate the exact center of the list. Crucially, it tracks a prev pointer
 *           to slice the connection between the first half and the second half (prev.next = null). This completely isolates the two halves into independent sub-lists.
 *           It takes the second half of the list and flips its direction in-place using an iterative pointer-swapping loop. For example, if the second half was 4 -> 5 -> 6, it becomes 6 -> 5 -> 4.
 *           This is necessary because we need to read the back half of the list in reverse order.
 *           The while loop alternates between the nodes of the first half and the freshly reversed second half. It uses a brilliant, minimal variable swap routine to zigzag the pointers back and forth until
 *           the second half runs dry, locking the final intertwined structure in place.
 *
 *
 * TC: O(N) Let N be the number of nodes in list.
 * SC: O(1)
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 */
