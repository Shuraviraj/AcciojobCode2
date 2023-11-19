package NovFrontEnd1.day19.UniquePathsII;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] memo = new int[n][m];
        for (int[] e : memo) Arrays.fill(e, -1);
        int cnt = f(n - 1, m - 1, mat, memo);
        return cnt;
    }

    private static int f(int r, int c, ArrayList<ArrayList<Integer>> mat, int[][] memo) {
        if (r < 0 || c < 0) return 0;
        if (mat.get(r).get(c) == -1) return 0;
        if (memo[r][c] != -1) return memo[r][c];
        if (r == 0 && c == 0) return 1;
        int left = f(r - 1, c, mat, memo);
        int top = f(r, c - 1, mat, memo);
        return memo[r][c] = left + top;
    }
}
