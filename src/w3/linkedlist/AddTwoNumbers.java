package w3.linkedlist;

public class AddTwoNumbers {

    public LinkedListUtil.ListNode addTwoNumbers(LinkedListUtil.ListNode l1, LinkedListUtil.ListNode l2) {
        LinkedListUtil.ListNode dummy = new LinkedListUtil.ListNode(0);
        LinkedListUtil.ListNode node = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry == 1){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            node.next = new LinkedListUtil.ListNode(sum % 10);
            node = node.next;
            carry = sum / 10;

        }


        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListUtil linkedListUtil = new LinkedListUtil();
        LinkedListUtil.ListNode l1 = new LinkedListUtil.ListNode(2);
        l1.next = new LinkedListUtil.ListNode(4);
        l1.next.next = new LinkedListUtil.ListNode(3);

        LinkedListUtil.ListNode l2 = new LinkedListUtil.ListNode(5);
        l2.next = new LinkedListUtil.ListNode(6);
        l2.next.next = new LinkedListUtil.ListNode(4);

        AddTwoNumbers obj = new AddTwoNumbers();
        LinkedListUtil.ListNode resHead = obj.addTwoNumbers(l1, l2);
        linkedListUtil.printList(resHead);
    }
}

/*
 * Approach: It initializes a dummy node with a value of 0.
 *           The while loop runs as long as there is still data to process. It checks three things: if l1 has digits left,
 *           if l2 has digits left, or if there is a leftover carry from the previous addition.
 *           In each iteration, it extracts the values from l1 and l2 (if they aren't null),
 *           adds them together along with any existing carry. sum % 10 isolates the single digit that belongs in the current position.
 *           sum / 10 calculates the carry-over for the next column via integer division. The pointers l1, l2, and node advance forward
 *           to prepare for the next position.
 *
 * TC : O(max(N, M))  Let N be the length of the first linked list (l1) and M be the length of the second linked list (l2).
 * SC: O(max(N, M))
 *
 * Input: l1 = [2,4,3] , l2 = [5,6,4]
 * Output: [7,0,8]
 *
 */