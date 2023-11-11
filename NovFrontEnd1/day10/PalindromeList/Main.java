package NovFrontEnd1.day10.PalindromeList;

import java.util.ArrayList;
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
        System.out.println(A.isPalindrome(llist.head));
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
        if (head == null) head = node;
        else tail.next = node;
        tail = node;
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
    boolean isPalindrome(Node head) {
        ArrayList<Integer> al = new ArrayList<>();
        while (head != null) {
            al.add(head.data);
            head = head.next;
        }
        int s = 0, e = al.size() - 1;
        while (s < e) {
            if (!al.get(s).equals(al.get(e))) return false;
            s++;
            e--;
        }
        return true;
    }
}