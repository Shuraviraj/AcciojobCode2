package Nov.day4.Q1;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static int ParvAndCards(int[] nums) {
        int n = nums.length;
        boolean[] b = new boolean[n];
        Arrays.fill(b, true);
        return recur(nums, n, b);
    }

    static int recur(int[] nums, int n, boolean[] b) {
        if (n == 0) return 0;
        // removing every card
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!b[i]) continue;

            int l = i - 1;
            while (l >= 0 && !b[l]) l--;
            int r = i + 1;
            while (r < nums.length && !b[r]) r++;

            int removed = nums[i];

            b[i] = false;
            int curAns = ((l == -1 ? 1 : nums[l]) * (r == nums.length ? 1 : nums[r]) * removed) + recur(nums, n - 1, b);
            b[i] = true;

            ans = Math.max(ans, curAns);
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.print(Solution.ParvAndCards(arr));
    }
}