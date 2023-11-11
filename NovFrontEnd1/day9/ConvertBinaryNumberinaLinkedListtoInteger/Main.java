package NovFrontEnd1.day9.ConvertBinaryNumberinaLinkedListtoInteger;

public class Main {
    public static void main(String[] args) {
    }
}

class Solution {
    public int getDecimalValue(ListNode head) {
        int depth = getDepth(head);
        return sol(depth - 1, head);
    }

    private int sol(int depth, ListNode head) {
        if (head == null) return 0;
        int myVal = head.val == 0 ? 0 : (int) Math.pow(2, depth);
        return myVal + sol(depth - 1, head.next);
    }

    private int getDepth(ListNode head) {
        if (head == null) return 0;
        return 1 + getDepth(head.next);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}