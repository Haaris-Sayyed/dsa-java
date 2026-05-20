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
