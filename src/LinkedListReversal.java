class LinkedListReversal{
    static ListNode[] reverseLinkedList(ListNode node, int k){

        ListNode previous = null;
        ListNode current = node;
        ListNode next = null;

        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return new ListNode[]{previous, current};
    }
}