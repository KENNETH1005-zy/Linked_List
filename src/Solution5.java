import java.util.*;
class Solution5 {
    public static void swap (ListNode node1, ListNode node2 ) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode front = null;
        int count = 0;
        ListNode end = null;
        ListNode curr = head;
        while (curr != null) {
            count += 1;
            if (end != null) {
                end = end.next;
            }
            if (count == k) {
                front = curr;
                end = head;
            }
            curr = curr.next;
        }
        swap (front, end);
        return head;
    }
    public static void main(String[] args) {

        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(6, 9, 3, 10, 7, 4, 6),
                Arrays.asList(6, 9, 3, 4),
                Arrays.asList(6, 2, 3, 6, 9),
                Arrays.asList(6, 2)
        );
        int[] k = {
                2, 3, 2, 3, 1
        };

        for(int i=0; i<input.size(); i++){
            System.out.print(i+1);
            LinkedList list = new LinkedList(input.get(i));
            System.out.print(".\tOriginal linked list is: ");
            PrintList.display(list.head);
            System.out.println("\tk: "+k[i]);
            System.out.print("\tLinked list with swapped values: ");
            PrintList.display(swapNodes(list.head,k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}