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
