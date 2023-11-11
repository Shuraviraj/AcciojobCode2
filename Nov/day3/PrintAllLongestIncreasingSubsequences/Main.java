package Nov.day3.PrintAllLongestIncreasingSubsequences;

import java.util.*;

public class Main {


    public static void solution(int[] arr) {
        int n = arr.length, maxLisValue = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int maxi = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] <= arr[i]) maxi = Math.max(maxi, dp[j]);
            }
            dp[i] = maxi + 1;
            maxLisValue = Math.max(maxLisValue, dp[i]);
        }
        System.out.println(maxLisValue);
        Queue<Help> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (dp[i] == maxLisValue) q.offer(new Help(i, "" + arr[i]));
        ArrayList<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Help curr = q.poll();
            if (dp[curr.index] == 1) {
                ans.add(curr.psf);
                continue;
            }
            for (int i = curr.index - 1; i >= 0; i--) {
                if (arr[i] < arr[curr.index] && dp[i] == dp[curr.index] - 1) {
                    q.offer(new Help(i, arr[i] + " " + curr.psf));
                }
            }
        }
        Collections.sort(ans);
        for (String s : ans) System.out.println(s);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }

    static class Help {
        int index;
        String psf;

        public Help(int index, String psf) {
            this.index = index;
            this.psf = psf;
        }
    }
}