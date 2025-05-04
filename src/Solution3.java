import java.util.*;

class Solution3 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i =0; i < left -1 ; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(6, 9, 3, 10, 7, 4, 6),
                Arrays.asList(6, 9, 3, 4),
                Arrays.asList(6, 2, 3, 6, 9),
                Arrays.asList(6, 2)
        );

        int[] left = {1, 3, 2, 1, 1};
        int[] right = {5, 6, 4, 3, 2};
        for(int i=0; i<input.size(); i++){
            System.out.print(i+1);
            LinkedList list = new LinkedList(input.get(i));
            System.out.print(".\tOriginal linked list:  ");
            PrintList.display(list.head);
            System.out.print("\tLeft: " + left[i] + ", Right: " + right[i] + "\n\n");
            System.out.print("\tReversed linked list:  " );
            PrintList.display(reverseBetween(list.head,left[i],right[i]));
        }
    }
}