package NovFrontEnd1.day9.ReverseInGroupsOfK;

import java.util.Scanner;

class Node {
    int val;
    Node next;

    Node(int d) {
        val = d;
        next = null;
    }
}

class LinkedList {
    Node head, tail;

    void push(Node new_node) {
        if (head == null && tail == null) {
            head = tail = new_node;
            return;
        }
        tail.next = new_node;
        tail = new_node;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Solution {
    public Node reverseKGroup(Node head, int k) {
        Node dumm = new Node(-1);
        dumm.next = head;
        Node start = dumm, end = dumm;
        while (end != null) {
            int cnt = 0;
            while (cnt < k) {
                if (end == null) return dumm.next;
                end = end.next;
                cnt++;
            }
            if (end == null) return dumm.next;
            Node fut = start.next;
            reverse(start, start.next, end, end.next);
            start = fut;
            end = start;
        }
        return dumm.next;
    }

    private void reverse(Node beforeStart, Node start, Node end, Node afterEnd) {
        if (end == null) return;
        Node prev = null, curr = start;
        while (prev != end) {
            Node fut = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fut;
        }
        beforeStart.next = prev;
        start.next = afterEnd;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        LinkedList llist = new LinkedList();
        int h1 = sc.nextInt();
        Node head = new Node(h1);
        llist.push(head);
        for (int i = 1; i < n; i++) {
            int data = sc.nextInt();
            llist.push(new Node(data));
        }
        Solution Obj = new Solution();
        head = Obj.reverseKGroup(head, k);
        llist.printList(head);
        sc.close();
    }
}