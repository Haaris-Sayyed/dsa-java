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

/*
 *
 * Approach: This code implements a two-pass hash map approach to clone a deep copy of a linked list with next and random pointers.
 *           The First Pass: The algorithm walks through the original list from head to tail, creating a brand-new, isolated clone
 *                           for every node it encounters. It maps these relationships inside a HashMap<OldNode, NewNode>, using the original nodes as
 *                           keys and the deep copies as values. At this stage, only the node values are copied; the pointers are left empty.
 *           The Second Pass: The algorithm resets back to the head of the list and walks through it a second time. Using the hash map,
 *                            it connects the next and random pointers of each cloned node by looking up where the original node's pointers point to.
 *                            Because the map natively returns null for a null key, the edges of the list and empty random pointers resolve correctly without crashing.
 *
 * TC : O(N)  Let N be the total number of nodes in the linked list.
 * SC: O(N)
 *
 * Input: nums = [7,13,11]
 * Output: [7,13,11]
 *
 */