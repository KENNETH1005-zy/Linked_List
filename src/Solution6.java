import java.util.*;

class Solution6 {
    public static ListNode removeDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        List<List<Integer>> inputList = Arrays.asList(
                Arrays.asList(1, 2, 2, 3, 3, 3),
                Arrays.asList(-21, -21, -21, -21, -21, -21, -21),
                Arrays.asList(3, 7, 9),
                Arrays.asList(-100, -100, -100, -10, -10, 0, 10, 10, 100, 100, 100),
                Arrays.asList(-77, -77, -7, -7, -7, -7, 7, 7, 7, 7, 77, 77, 77, 77)
        );

        for (int i = 0; i < inputList.size(); i++) {
            LinkedList inputLinkedList = new LinkedList(inputList.get(i));

            System.out.print((i + 1) + ".\tInput: ");
            PrintList.display(inputLinkedList.head);

            System.out.print("\n\tOutput: ");
            inputLinkedList.head = removeDuplicates(inputLinkedList.head);
            PrintList.display(inputLinkedList.head);

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}