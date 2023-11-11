package Nov.day7.FrogJump;

import java.util.*;

@SuppressWarnings("unchecked")
class Solution {
    public static int countPaths(int n, int[][] roads) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= Math.max(roads.length, n); i++) graph.add(new ArrayList<>());
        for (int[] r : roads) {
            graph.get(r[0]).add(new Pair(r[1], r[2]));
            graph.get(r[1]).add(new Pair(r[0], r[2]));
        }
        int[] vis = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        int ans = 0, minDist = -1;
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.city == n - 1) {
                if (minDist == -1 || curr.dist == minDist) {
                    minDist = curr.dist;
                    ans++;
                }
            }
            for (Pair nbr : graph.get(curr.city)) {
                int finaDist = curr.dist + nbr.dist;
                if (vis[nbr.city] < finaDist) continue;
                vis[nbr.city] = finaDist;
                pq.add(new Pair(nbr.city, finaDist));
            }
        }
        return ans % ((int) 1e9 + 7);
    }

    static class Pair {
        int city;
        int dist;

        public Pair(int city, int dist) {
            this.city = city;
            this.dist = dist;
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; ++i) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();

        }
        System.out.print(Solution.countPaths(n, edges));
    }
}
