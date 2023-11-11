package Nov.day3.Printallresultsin01Knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        Solution obj = new Solution();
        obj.solve(n, values, wts, cap);

    }
}

class Solution {
    public static void solve(int n, int[] values, int[] wts, int cap) {
        int l = values.length;
        int[][] dp = new int[l + 1][cap + 1];
        for (int wt = 0; wt <= l; wt++) {
            for (int c = 0; c <= cap; c++) {
                if (c == 0 || wt == 0) {
                    dp[wt][c] = 0;
                    continue;
                }
                int notPick = dp[wt - 1][c];
                int pick = c - wts[wt - 1] >= 0 ? dp[wt - 1][c - wts[wt - 1]] + values[wt - 1] : 0;
                dp[wt][c] = Math.max(notPick, pick);
            }
        }
        System.out.println(dp[l][cap]);

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair("", l, cap));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.i, j = p.j;
            String psf = p.psf;

            if (i == 0 || j == 0) {
                System.out.println(psf);
                continue;
            }

            //not pick
            if (dp[i][j] == dp[i - 1][j]) q.offer(new Pair(psf, i - 1, j));
            //pick
            if (j - wts[i - 1] >= 0) {
                int dpValOfRemaining = dp[i - 1][j - wts[i - 1]];
                if (dp[i][j] == values[i - 1] + dpValOfRemaining) {
                    q.add(new Pair((i - 1) + " " + psf, i - 1, j - wts[i - 1]));
                }
            }
        }
    }

    private static int recur(int[] values, int[] wts, int idx, int cap) {
        if (idx == -1 || cap == 0) return 0;
        //pickme
        int pick = cap - wts[idx] >= 0 ? recur(values, wts, idx - 1, cap - wts[idx]) + values[idx] : 0;

        //dont pick me
        int excludeMe = recur(values, wts, idx - 1, cap);

        return Math.max(pick, excludeMe);
    }

    static class Pair {
        String psf;
        int i, j;

        public Pair(String psf, int i, int j) {
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    }
}
