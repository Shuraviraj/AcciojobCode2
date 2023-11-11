package Nov.day2.LongestCommonSubsequence;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();             // Take size of both the strings as input
        int q = sc.nextInt();
        String a = sc.next();            // Take both the string as input
        String b = sc.next();
        Solution obj = new Solution();
        System.out.println(obj.lcs(p, q, a, b));
        sc.close();

    }
}


class Solution {
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String a, String b) {
//        return recur(x - 1, y - 1, a, b);
        return tab(x, y, a, b);
    }

    private static int tab(int alen, int blen, String a, String b) {
        int[][] dp = new int[alen + 1][blen + 1];
        for (int adx = 0; adx <= alen; adx++) {
            for (int bdx = 0; bdx <= blen; bdx++) {
                if (adx == 0 || bdx == 0) {
                    dp[adx][bdx] = 0;
                } else if (a.charAt(adx - 1) == b.charAt(bdx - 1)) {
                    dp[adx][bdx] = dp[adx - 1][bdx - 1] + 1;
                } else {
                    dp[adx][bdx] = Math.max(dp[adx][bdx - 1], dp[adx - 1][bdx]);
                }
            }
        }
        return dp[alen][blen];
    }

    private static int recur(int adx, int bdx, String a, String b) {
        if (adx == -1 || bdx == -1) return 0;
        if (a.charAt(adx) == b.charAt(bdx)) return 1 + recur(adx - 1, bdx - 1, a, b);
        return Math.max(recur(adx, bdx - 1, a, b), recur(adx - 1, bdx, a, b));
    }

}