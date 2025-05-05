import java.util.*;
class Solution4 {
    public static ListNode reorderList(ListNode head){
        if (head == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode first = head;
        ListNode second = prev;
        ListNode temp = head;
        while (second.next != null) {
            temp = first.next;
            first.next = second;
            second = second.next;
            first.next.next = temp;
            first = first.next.next;
        }
        return head;
    }
    public static void main(String[] args) {
        List<List<Integer>> inputLists = Arrays.asList(
                Arrays.asList(1, 1, 2, 2, 3, -1, 10, 12),
                Arrays.asList(10, 20, -22, 21, -12),
                Arrays.asList(1, 1, 1),
                Arrays.asList(-2, -5, -6, 0, -1, -4),
                Arrays.asList(3, 1, 5, 7, -4, -2, -1, -6)
        );

        for (int i = 0; i < inputLists.size(); i++) {
            LinkedList obj = new LinkedList(inputLists.get(i));

            System.out.print((i + 1) + ".\tOriginal list: ");
            PrintList.display(obj.head);

            reorderList(obj.head);

            System.out.print("\tAfter folding: ");
            PrintList.display(obj.head);

        }
    }
}