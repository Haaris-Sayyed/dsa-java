package w3.linkedlist;

import java.util.HashMap;
import java.util.Map;

class CopyListNode {
    int val;
    CopyListNode next;
    CopyListNode random;

    public CopyListNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class CopyListWithRandomPointer {

    public CopyListNode copyRandomList(CopyListNode head) {
        if(head == null) return null;

        Map<CopyListNode, CopyListNode> oldToNew = new HashMap<>();

        CopyListNode curr = head;
        while (curr != null){
            oldToNew.put(curr, new CopyListNode(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null){
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }

        return oldToNew.get(head);
    }

    public void printList(CopyListNode head){
       CopyListNode node = head;

       while (node != null){
           String s = node.random == null ? " => NULL" : " => " + node.random.val + " -> ";
           System.out.print(node.val + s);
           node = node.next;

       }
    }


    public static void main(String[] args) {
        CopyListNode head = new CopyListNode(7);
        head.next = new CopyListNode(13);
        head.next.random = head;
        head.next.next = new CopyListNode(11);
        head.random = head.next.next;

        CopyListWithRandomPointer obj = new CopyListWithRandomPointer();
        CopyListNode copyHead = obj.copyRandomList(head);
        obj.printList(copyHead);
    }
}
