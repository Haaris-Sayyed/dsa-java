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
