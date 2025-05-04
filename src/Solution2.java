import java.util.*;

class Solution2 {
    public static ListNode reverseKGroups(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ptr = dummy;
        while (ptr != null) {
            ListNode tracker = ptr;
            for (int i = 0; i < k; i++) {
                if ( tracker == null) {
                    break;
                }
                tracker = tracker.next;
            }
            if (tracker == null) {
                break;
            }
            ListNode[] updatedNodes = LinkedListReversal.reverseLinkedList(ptr.next, k);
            ListNode previous = updatedNodes[0];
            ListNode current = updatedNodes[1];
            ListNode lastNodeOfReversedGroup = ptr.next;
            lastNodeOfReversedGroup.next = current;
            ptr.next = previous;
            ptr = lastNodeOfReversedGroup;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        List<List<Integer>> inputList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                Arrays.asList(3, 4, 5, 6, 2, 8, 7, 7),
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(1)
        );

        int[] k = {3, 2, 1, 7, 1};

        for (int i = 0; i < inputList.size(); ++i) {
            LinkedList inputLinkedList = new LinkedList(inputList.get(i));

            System.out.print((i + 1) + ".\tLinked list: ");
            PrintList.display(inputLinkedList.head);
            System.out.println();

            System.out.print("\n\tReversed linked list: ");
            ListNode result = reverseKGroups(inputLinkedList.head, k[i]);
            PrintList.display(result);
            System.out.println();

            String hyphens = new String(new char[100]).replace('\0', '-');
            System.out.println(hyphens);
        }
    }
}