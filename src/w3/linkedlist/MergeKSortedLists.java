package w3.linkedlist;

public class MergeKSortedLists {

    public LinkedListUtil.ListNode mergeKLists(LinkedListUtil.ListNode[] lists) {
        if(lists.length == 0) return null;
        LinkedListUtil.ListNode mergedListHead = lists[0];
        return mergedListHead.next;
    }


}
