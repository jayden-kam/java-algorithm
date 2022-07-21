package jayden.learn.cases.leetcode;

public class LinkedListProblems {

    public static void main(String[] args) {
        testReverseLinkedListII();
    }

    public static void testReverseLinkedListII() {
        {
            ListNode n5 = new ListNode(5, null);
            ListNode n4 = new ListNode(4, n5);
            ListNode n3 = new ListNode(3, n4);
            ListNode n2 = new ListNode(2, n3);
            ListNode n1 = new ListNode(1, n2);
            LinkedListProblems solution = new LinkedListProblems();
            if ("[1, 4, 3, 2, 5]".equals(solution.reverseBetween(n1, 2, 4).toString())) {
                System.out.println("Testcase 1: passed");
            } else {
                System.err.println("Testcase 1: failed");
            }
        }
        {
            ListNode n5 = new ListNode(5, null);
            LinkedListProblems solution = new LinkedListProblems();
            if ("[5]".equals(solution.reverseBetween(n5, 1, 1).toString())) {
                System.out.println("Testcase 2: passed");
            } else {
                System.err.println("Testcase 2: failed");
            }
        }
    }

    /*
    Reverse Linked List II

    Given the head of a singly linked list and two integers left and right where left <= right,
     reverse the nodes of the list from position left to position right, and return the reversed list.


    Example 1

    Input: head = [1,2,3,4,5], left = 2, right = 4
    Output: [1,4,3,2,5]


    Example 2

    Input: head = [5], left = 1, right = 1
    Output: [5]
    */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int steps = right - left;
        if (steps <= 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(0, head);
        ListNode start = dummyHead;
        while (--left > 0) {
            start = start.next;
        }
        ListNode end = start.next;
        while (steps-- > 0) {
            ListNode temp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = temp;
        }
        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder output = new StringBuilder("[");
            do {
                output.append(node.val).append(", ");
                node = node.next;
            } while (node != null);
            if (output.length() > 0) {
                output.setLength(output.length() - 2);
                output.append("]");
            }
            return output.toString();
        }
    }
}
