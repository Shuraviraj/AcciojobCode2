package NovFrontEnd1.day9.SortedLinkedList;

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

        Accio A = new Accio();
        A.checkListSorted(llist.head);

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

class Accio {
    static void checkListSorted(Node head) {
        Node prev = head, curr = head.next;
        while (curr != null) {
            if (prev.data > curr.data) break;
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) System.out.println("YES");
        else System.out.println("NO");
    }
}