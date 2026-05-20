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
