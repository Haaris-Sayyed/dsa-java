package w3.linkedlist;

public class ReverseNodesInKGroup {

    public LinkedListUtil.ListNode reverseKGroup(LinkedListUtil.ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        }

        LinkedListUtil.ListNode current = head;
        LinkedListUtil.ListNode prev = null;

        while (true){

            LinkedListUtil.ListNode checker = current;
            for (int i = 0; i < k; i++) {
                if (checker == null) {
                    return head;
                }
                checker = checker.next;
            }

            LinkedListUtil.ListNode last = prev;
            LinkedListUtil.ListNode newEnd = current;

            for (int i = 0; current != null &&  i < k; i++) {
                LinkedListUtil.ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            if(last != null){
                last.next = prev;
            }else{
                head = prev;
            }

            newEnd.next = current;
            if(current == null) break;
            prev = newEnd;

        }

        return head;
    }

    public static void main(String[] args) {
        LinkedListUtil linkedListUtil = new LinkedListUtil();
        LinkedListUtil.ListNode head = linkedListUtil.createLinkedList(5);

        ReverseNodesInKGroup obj = new ReverseNodesInKGroup();
        head = obj.reverseKGroup(head,2);
        linkedListUtil.printList(head);
    }

}

/*
 *
 * Approach:
 *          1. The Look-Ahead Guard: Before touching any pointers, a checker loop walks k nodes ahead. If it hits null before reaching k, it means there aren't enough nodes left to form a complete group. The algorithm immediately aborts and returns the head, guaranteeing that trailing sub-lists remain intact.
 *          2. The Sub-List Reversal: If a full group of k nodes is confirmed, a standard 4-step pointer swapping loop runs exactly k times. This flips the internal directions of that segment's nodes in-place.
 *          3. Reconnecting the Boundaries: After a group is reversed, it must be spliced back into the main list without breaking the chain:
 *              3.1 The Left Connection: The algorithm connects the tail of the previous processed group (last) to the new head of the current reversed segment (prev). If last is null, it means we just flipped the very first group, so it updates the global head pointer.
 *              3.2 The Right Connection: The original start of the group has now spun around to become the new end (newEnd). The code links newEnd.next to current (which points to the starting node of the next upcoming group).
 *          4. Window Shifting: Finally, it sets prev = newEnd to establish the trailing boundary anchor, readying the algorithm to jump into the next block.
 *
 * TC: O(N) Let N be the number of nodes in list.
 * SC: O(1)
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 */
