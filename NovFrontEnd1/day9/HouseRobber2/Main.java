package NovFrontEnd1.day9.HouseRobber2;

import java.util.Scanner;

class Accio {
    public int HouseRobber(int[] arr) {
        if (arr.length == 1) return arr[0];
        int a1 = rob(arr, 1, arr.length - 1);
        int a2 = rob(arr, 0, arr.length - 2);
        return Math.max(a1, a2);
    }

    private int rob(int[] arr, int s, int e) {
        int prev2 = 0, prev = arr[s];
        for (int i = s + 1; i <= e; i++) {
            int notTake = prev;
            int take = prev2 + arr[i];
            int maxi = Math.max(notTake, take);

            prev2 = prev;
            prev = maxi;
        }
        return prev;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.HouseRobber(arr));

    }
}