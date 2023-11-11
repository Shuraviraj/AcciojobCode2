package Nov.day4.MatrixChainMultiplication;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(MatrixChainOrder(arr, n));
    }

    static int MatrixChainOrder(int p[], int n) {
//        return recur(p, 0, n - 1);
        return tab(p, n);
    }

    private static int tab(int[] p, int n) {
        int[][] dp = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (i == j || i + 1 == j) {
                    dp[i][j] = 0;
                    continue;
                }
                int best = Integer.MAX_VALUE;
                int ends = p[i] * p[j];
                for (int cut = j - 1; cut > i; cut--) {
//                    int total = dp[i][cut] + (ends * p[cut]);
                    int total = dp[i][cut] + (ends * p[cut]) + dp[cut][j];
                    best = Math.min(best, total);
                }
                dp[i][j] = best;
            }
        }
        return dp[0][n - 1];
    }

    private static int recur(int[] p, int start, int end) {
        if (start + 1 == end) return 0;
        int minCost = Integer.MAX_VALUE;

        for (int cut = start + 1; cut < end; cut++) {
            int left = recur(p, start, cut);
            int right = recur(p, cut, end);
            int merge = p[start] * p[cut] * p[end];
            int tot = left + right + merge;
            minCost = Math.min(minCost, tot);
        }

        return minCost;
    }
}