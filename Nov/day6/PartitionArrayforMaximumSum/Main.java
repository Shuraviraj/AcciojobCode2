package Nov.day6.PartitionArrayforMaximumSum;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
    }
}

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int ind = n - 1; ind >= 0; ind--) {
            int maxAns = 0, len = 0, maxi = 0;
            for (int j = ind; j < ind + k; j++) {
                if (j >= n) continue;
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = (len * maxi) + dp[j + 1];
                maxAns = Math.max(sum, maxAns);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
        

//        int[] memo = new int[arr.length];
//        return recur(arr, k, 0, memo);
    }

    private int recur(int[] arr, int k, int idx, int[] memo) {
        int n = arr.length;

        if (idx == n) return 0;
        if (memo[idx] != 0) return memo[idx];

        int ans = 0, len = 0, max = 0;

        for (int i = idx; i < idx + k; i++) {
            if (i >= n) continue;
            len++;
            max = Math.max(max, arr[i]);
            int right = recur(arr, k, i + 1, memo);
            ans = Math.max(len * max + right, ans);
        }

        return memo[idx] = ans;
    }
}