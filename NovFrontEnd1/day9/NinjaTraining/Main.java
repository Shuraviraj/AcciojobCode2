package NovFrontEnd1.day9.NinjaTraining;

public class Main {
    public static int ninjaTraining(int n, int points[][]) {
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
        for (int day = 1; day < n; day++) {
            int[] tmp = new int[4];
            for (int last = 0; last < 4; last++) {
                int best = 0;
                for (int task = 0; task < 3; task++) {
                    if (last == task) continue;
                    int curr = points[day][task];
                    curr += dp[task];
                    best = Math.max(best, curr);
                }
                tmp[last] = best;
            }
            dp = tmp;
        }
        return dp[3];
//        for (int[] d : dp) Arrays.fill(d, -1);
//        return recur(points, n - 1, 3, dp);
    }

    private static int recur(int[][] points, int day, int last, int[][] dp) {
        if (day == -1) return 0;
        if (dp[day][last] != -1) return dp[day][last];

        int best = 0;
        for (int task = 0; task < 3; task++) {
            if (task == last) continue;
            int curr = points[day][task];
            curr += recur(points, day - 1, task, dp);
            best = Math.max(best, curr);
        }
        return dp[day][last] = best;
    }

    public static void main(String[] args) {
    }
}
