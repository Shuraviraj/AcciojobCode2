package NovFrontEnd1.day10.ReverseaStack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class StackNode {
    int data;
    StackNode next;

    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        //taking testcases

        String str = br.readLine();
        int n = Integer.parseInt(str);

        String str1 = br.readLine();
        String[] starr1 = str1.split(" ");
        Stack s = new Stack();
        for (int j = 0; j < n; j++) {
            s.push(Integer.parseInt(starr1[j]));
        }

        s.reverse();
        s.display();

        out.close();
    }
}

class Stack {
    StackNode top;
    
    public void push(int data) {
        if (this.top == null) {
            top = new StackNode(data);
            return;
        }
        StackNode s = new StackNode(data);
        s.next = this.top;
        this.top = s;
    }

    public StackNode pop() {
        StackNode s = this.top;
        this.top = this.top.next;
        return s;
    }

    public void display() {
        StackNode s = this.top;
        while (s != null) {
            System.out.print(s.data + " ");
            s = s.next;
        }
        System.out.println();
    }

    public void reverse() {
        StackNode prev = null, curr = this.top;
        while (curr != null) {
            StackNode fut = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fut;
        }
        this.top = prev;
    }
}