package w3.linkedlist;

public class LinkedListUtil {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode createLinkedList(int size){
        ListNode head = new ListNode(1);
        ListNode temp = head;
        for (int i = 2; i <= size; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        return head;
    }

    public void printList(ListNode node){
        while (node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("NULL");
    }

}
