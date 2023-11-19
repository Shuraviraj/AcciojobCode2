package NovFrontEnd1.day16.MatrixTraversalusingRecursion;

import java.util.Scanner;

class Solution {
    public void MatTraverseRecur(int[][] mat) {
        f(mat, 0, 0);
    }

    private void f(int[][] mat, int r, int c) {
        int row = mat.length, col = mat[0].length;
        if (c == col) {
            r = r + 1;
            c = 0;
            System.out.println();
        }
        if (r == row) return;
        System.out.print(mat[r][c] + " ");
        f(mat, r, c + 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] mat = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.MatTraverseRecur(mat);
    }
}