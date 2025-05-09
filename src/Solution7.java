import java.util.*;

class Solution7 {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        int split = size / k;
        int remaining = size % k;
        current = head;
        ListNode prev = null;
        for (int i = 0; i < k; i++) {
            ans[i] = current;
            int NodeSize = split + (remaining > 0 ? 1 : 0);
            if (remaining > 0) remaining--;
            for (int j = 0; j < NodeSize; j++) {
                prev = current;
                if (current != null) {
                    current = current.next;
                }
            }
            if (prev != null) {
                prev.next = null;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(9, 7, 8, 7, 7, 6),
                Arrays.asList(2, 3, 5, 7, 11),
                Arrays.asList(4, 4, 4, 4, 4),
                Arrays.asList(1, 2, 3, 11, 22, 33),
                Arrays.asList(1, 2, 6, 3, 4, 5, 6)
        );

        int[] ks = {7, 2, 4, 3, 6};

        for (int i = 0; i < lists.size(); i++) {
            LinkedList inputLinkedList = new LinkedList(lists.get(i));
            System.out.print((i + 1) + ". \tLinked list: ");
            PrintList.display(inputLinkedList.head);

            System.out.println("\n\tk: " + ks[i]);
            ListNode[] result = splitListToParts(inputLinkedList.head, ks[i]);

            System.out.print("\tLinked list parts: [");
            for (int j = 0; j < result.length; j++) {
                if (result[j] != null) {
                    System.out.print("[");
                    ListNode part = result[j];
                    while (part != null) {
                        System.out.print(part.val);
                        if (part.next != null) System.out.print(", ");
                        part = part.next;
                    }
                    System.out.print("]");
                } else {
                    System.out.print("[]");
                }
                if (j < result.length - 1) System.out.print(", ");
            }
            System.out.println("]");
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}