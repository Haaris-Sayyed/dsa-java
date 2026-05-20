package w3.linkedlist;

public class ReverseNodesInKGroup {

    public LinkedListUtil.ListNode reverseKGroup(LinkedListUtil.ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        }

        LinkedListUtil.ListNode current = head;
        LinkedListUtil.ListNode prev = null;

        while (true){

            LinkedListUtil.ListNode checker = current;
            for (int i = 0; i < k; i++) {
                if (checker == null) {
                    return head;
                }
                checker = checker.next;
            }

            LinkedListUtil.ListNode last = prev;
            LinkedListUtil.ListNode newEnd = current;

            for (int i = 0; current != null &&  i < k; i++) {
                LinkedListUtil.ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            if(last != null){
                last.next = prev;
            }else{
                head = prev;
            }

            newEnd.next = current;
            if(current == null) break;
            prev = newEnd;

        }

        return head;
    }
}
