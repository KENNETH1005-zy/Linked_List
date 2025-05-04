import java.util.*;

class Solution {
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
    public static void main(String[] args) {

        List<List<Integer>> flatList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(3, 2, 1),
                Arrays.asList(10),
                Arrays.asList(1, 2)
        );

        for (int i = 0; i < flatList.size(); i++) {

            LinkedList inputLinkedList = new LinkedList(flatList.get(i));
            System.out.print((i + 1) + ".\tInput linked list: ");
            PrintList.display(inputLinkedList.head);
            System.out.print("\n\tReversed linked list: ");
            PrintList.display(reverse(inputLinkedList.head));
            System.out.println();
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}