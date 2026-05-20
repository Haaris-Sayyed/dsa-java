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
