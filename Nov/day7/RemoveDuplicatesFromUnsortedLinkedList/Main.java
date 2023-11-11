package Nov.day7.RemoveDuplicatesFromUnsortedLinkedList;

import java.util.HashSet;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList llist = new LinkedList();
        int a1 = sc.nextInt();
        Node head = new Node(a1);
        llist.addToTheLast(head);
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            llist.addToTheLast(new Node(a));
        }
        Solution A = new Solution();
        llist.head = A.removeDuplicate(llist.head);
        llist.printList();

    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}

class Solution {
    public static Node removeDuplicate(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;
        Node curr = dummy.next, prev = dummy;
        HashSet<Integer> hs = new HashSet<>();
        while (curr != null) {
            int me = curr.data;
            if (!hs.contains(me)) {
                hs.add(me);
                prev = curr;
            } else prev.next = curr.next;
            curr = curr.next;
        }
        return dummy.next;
    }

}