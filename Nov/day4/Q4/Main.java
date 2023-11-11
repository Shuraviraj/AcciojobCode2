package Nov.day4.Q4;

public class Main {
    public static void main(String[] args) {
        System.out.println(ways(7, 1));
    }

    private static long ways(int n, int i) {
        if (n == 0) return 1L;
        if (i > n) return 0;
        long p = ways(n - i, i + 1), no = ways(n, i + 1);
        return p + no;
    }
}
