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
