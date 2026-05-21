package w3.linkedlist;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public LinkedListUtil.ListNode mergeKLists(LinkedListUtil.ListNode[] lists) {
        LinkedListUtil.ListNode head = new LinkedListUtil.ListNode(0);
        LinkedListUtil.ListNode curr = head;
        Queue<LinkedListUtil.ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(LinkedListUtil.ListNode list : lists){
            if(list != null){
                minHeap.offer(list);
            }
        }

        while(!minHeap.isEmpty()){
            LinkedListUtil.ListNode minNode = minHeap.poll();
            if(minNode.next != null){
                minHeap.offer(minNode.next);
            }
            curr.next = minNode;
            curr = curr.next;
        }

        return head.next;
    }

    public static void main(String[] args) {

        LinkedListUtil.ListNode l1 = new LinkedListUtil.ListNode(1);
        l1.next = new LinkedListUtil.ListNode(4);
        l1.next.next = new LinkedListUtil.ListNode(5);

        LinkedListUtil.ListNode l2 = new LinkedListUtil.ListNode(1);
        l2.next = new LinkedListUtil.ListNode(3);
        l2.next.next = new LinkedListUtil.ListNode(4);

        LinkedListUtil.ListNode l3 = new LinkedListUtil.ListNode(2);
        l3.next = new LinkedListUtil.ListNode(6);

        LinkedListUtil.ListNode[] listArray = new LinkedListUtil.ListNode[] { l1, l2, l3 };

        MergeKSortedLists obj = new MergeKSortedLists();
        LinkedListUtil linkedListUtil = new LinkedListUtil();
        linkedListUtil.printList(obj.mergeKLists(listArray));
    }

}

/*
 *
 * Approach: The algorithm loops through the input lists array and pushes the very first node (the head) of every non-empty linked list into the minHeap.
 *           The Priority Queue is initialized with a custom sorting rule: (a, b) -> a.val - b.val. This ensures that the node with the absolute smallest numerical value in the entire
 *           heap is always sitting perfectly at the top. The while loop pulls the absolute smallest node (minNode) off the top of the heap in O(log K) time and appends it directly to our building merged
 *           list via the curr pointer. As soon as a node is extracted, the algorithm checks if that specific node has a neighbor following it (minNode.next != null). If it does, it pushes that next node straight into the heap. This maintains a steady state where the heap always contains exactly one representative
 *           candidate from each active, remaining list. Once the heap runs empty, all nodes have been successfully sorted and woven together, and the dummy node's tracker (head.next) is returned.
 *
 * TC : O(N.logK)  Let K be the total number of linked lists in the input array, and let N be the total aggregate
 *              number of individual nodes across all lists combined.
 * SC: O(K)
 *
 * Input: [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 *
 */
