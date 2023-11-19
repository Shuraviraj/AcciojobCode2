package NovFrontEnd1.day19.UniquePathsIII;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static int UniquePaths3(int m, int n, int[][] grid) {
        int[][] startEnd = new int[2][2];
        int walk = 0, row = grid.length, col = grid[0].length;
        int[][] memo = new int[row][col];
        for (int[] e : memo) Arrays.fill(e, -1);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    walk++;
                    startEnd[0][0] = i;
                    startEnd[0][1] = j;
                } else if (grid[i][j] == 2) {
                    walk++;
                    startEnd[1][0] = i;
                    startEnd[1][1] = j;
                } else if (grid[i][j] == 0) walk++;
            }
        }

        return f(startEnd[1][0], startEnd[1][1], startEnd, walk, grid, memo);
    }

    private static int f(int r, int c, int[][] startEnd, int walk, int[][] grid, int[][] memo) {
        if (r == grid.length || r < 0 || c < 0 || c == grid[0].length) return 0; //out of bound
        if (grid[r][c] == -1) return 0; //cannot walk
        if (r == startEnd[0][0] && c == startEnd[0][1] && walk == 1) return 1;
        if (memo[r][c] != -1) return memo[r][c];

        grid[r][c] = -1; //mark as visited

        int top = f(r - 1, c, startEnd, walk - 1, grid, memo);
        int left = f(r, c - 1, startEnd, walk - 1, grid, memo);
        int down = f(r + 1, c, startEnd, walk - 1, grid, memo);
        int right = f(r, c + 1, startEnd, walk - 1, grid, memo);

        grid[r][c] = 0; //back tracked

        return memo[r][c] = top + left + down + right;
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                grid[i][j] = sc.nextInt();
            }
        }
        Solution obj = new Solution();
        int ans = obj.UniquePaths3(m, n, grid);
        System.out.println(ans);
    }
}