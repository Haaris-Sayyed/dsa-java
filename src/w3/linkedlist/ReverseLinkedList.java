package w3.linkedlist;

public class ReverseLinkedList {

    public LinkedListUtil.ListNode reverseList(LinkedListUtil.ListNode head) {
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

         ReverseLinkedList obj = new ReverseLinkedList();

         LinkedListUtil.ListNode head = linkedListUtil.createLinkedList(5);
         linkedListUtil.printList(head);
         LinkedListUtil.ListNode reverseListHead = obj.reverseList(head);
         linkedListUtil.printList(reverseListHead);

    }
}

/*
 *
 * Approach: This code implements the classic iterative in-place approach to completely flip the direction of a singly linked list.
 *           The while loop resolves this by executing a precise 4-step pointer rotation on every single node:
 *           1. ListNode next = curr.next; — Save the future. It bookmarks the next node so it doesn't get lost.
 *           2. curr.next = prev; — Flip the switch. This is the actual reversal step. The current node severs its forward link and points backward to the node behind it.
 *           3. prev = curr; — Shift the past. The prev pointer steps up to the current node, preparing to act as the new anchor for the next iteration.
 *           4. curr = next; — Step into the future. The curr pointer moves to the bookmarked next node to repeat the process.
 *
 *          Once curr steps into null, the loop finishes. The prev pointer is left sitting squarely on the absolute last node of the original list, which is now the brand-new head of your reversed list.
 *
 * TC: O(N) Let N be the number of nodes in list.
 * SC: O(1)
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 */
