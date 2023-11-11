package Nov.day7.houserobber;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2, 3, 1}));
    }
}

class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];

        int prev2 = 0, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {

            int notTakeMe = prev;
            int takeMe = nums[i] + (i > 1 ? prev2 : 0);

            int currMe = Math.max(notTakeMe, takeMe);
            prev2 = prev;
            prev = currMe;
        }
        return prev;
//        return dp[nums.length - 1];
//        Arrays.fill(dp, -1);
//        return recur(nums, nums.length - 1, dp);
    }

    private int recur(int[] nums, int i, int[] dp) {
        if (i == 0) return nums[i];
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];

        int pick = nums[i] + recur(nums, i - 2, dp);
        int notPick = recur(nums, i - 1, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}