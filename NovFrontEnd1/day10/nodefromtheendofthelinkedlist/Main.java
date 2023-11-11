package NovFrontEnd1.day10.nodefromtheendofthelinkedlist;

import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    void add(String data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new_node;
    }
}

class Solution {
    public String solve(Node head, int k) {
        int depth = getDepth(head);
        int idx = depth - k;
        while (idx-- > 0) head = head.next;
        return head.data;
    }

    private int getDepth(Node head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }

}

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        LinkedList l1 = new LinkedList();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            l1.add(sc.next());
        }

        Solution Ob = new Solution();
        String ans = Ob.solve(l1.head, k);

        System.out.println(ans);
    }
}