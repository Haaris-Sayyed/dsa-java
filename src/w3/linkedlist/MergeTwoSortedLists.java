package w3.linkedlist;

public class MergeTwoSortedLists {

    public LinkedListUtil.ListNode mergeTwoLists(LinkedListUtil.ListNode list1, LinkedListUtil.ListNode list2) {
        LinkedListUtil.ListNode dummyHead = new LinkedListUtil.ListNode(0);
        LinkedListUtil.ListNode current = dummyHead;

        while (list1 != null && list2 != null){
           if(list1.val <= list2.val){
               current.next = list1;
               list1 = list1.next;
           }else {
               current.next = list2;
               list2 = list2.next;
           }
           current = current.next;
        }

        current.next = list1 == null ? list2 : list1;

        return  dummyHead.next;
    }


    public static void main(String[] args) {
        LinkedListUtil linkedListUtil = new LinkedListUtil();

        LinkedListUtil.ListNode list1 = linkedListUtil.createLinkedList(5);
        LinkedListUtil.ListNode list2 = linkedListUtil.createLinkedList(3);

        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        LinkedListUtil.ListNode mergedListHead = obj.mergeTwoLists(list1, list2);
        linkedListUtil.printList(mergedListHead);
    }
}


/*
 *
 * Approach: The algorithm operates purely by restructuring existing pointers in-place, rather than wasting memory allocating brand-new nodes.
 *           It establishes a dummyHead node at the start. This acts as an anchor, allowing the current pointer to seamlessly
 *           append nodes without needing to check if the head of the merged list has been set yet. The while loop runs as long as both lists have remaining elements. At each step, it compares the values at list1 and list2.
 *           The smaller node is stitched directly onto current.next, and that list's pointer advances forward. Once the loop breaks, it means one of the lists has run completely dry. Because the original lists were already individually sorted, the algorithm doesn't need to loop through the remaining items of the survivor list.
 *           It uses a ternary operator to instantly link the rest of the non-empty list directly to current.next in a single assignment.
 *
 * TC: O(N + M) Let N be the number of nodes in list1 and M be the number of nodes in list2.
 * SC: O(1)
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 */