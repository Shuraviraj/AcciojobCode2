package NovFrontEnd1.da717.UniquePathsII;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static int UniquePaths2(int m, int n, int[][] obstacleGrid) {
        int[][] memo = new int[m][n];
        for (int[] e : memo) {
            Arrays.fill(e, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) memo[i][j] = 1;
                else if (obstacleGrid[i][j] == 1) memo[i][j] = 0;
                else if (i == 0) memo[i][j] = memo[i][j - 1];
                else if (j == 0) memo[i][j] = memo[i - 1][j];
                else {
                    int left = memo[i - 1][j];
                    int top = memo[i][j - 1];
                    memo[i][j] = left + top;
                }
            }
        }
        return memo[m - 1][n - 1];
//        return f(obstacleGrid, m - 1, n - 1, memo);
    }

    private static int f(int[][] obstacleGrid, int r, int c, int[][] memo) {
        if (r < 0 || c < 0) return 0;
        if (obstacleGrid[r][c] == 1) return 0;
        if (r == 0 && c == 0) return 1;
        if (memo[r][c] != -1) return memo[r][c];

        int top = f(obstacleGrid, r - 1, c, memo);
        int left = f(obstacleGrid, r, c - 1, memo);

        return memo[r][c] = top + left;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] obstacleGrid = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                obstacleGrid[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        int ans = obj.UniquePaths2(m, n, obstacleGrid);
        System.out.println(ans);
    }
}