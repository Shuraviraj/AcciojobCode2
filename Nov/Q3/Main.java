package Nov.Q3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int findNthCard(int n) {
        List<Integer> d = new ArrayList<>();
        d.add(1);
        int a = 0, b = 0, c = 0;

        while (d.size() < n) {
            int nc = Math.min(d.get(a) * 2, Math.min(d.get(b) * 5, d.get(c) * 7));
            d.add(nc);

            if (nc == d.get(a) * 2) {
                a++;
            }
            if (nc == d.get(b) * 5) {
                b++;
            }
            if (nc == d.get(c) * 7) {
                c++;
            }
        }

        return d.get(n - 1);
    }

    public static void main(String[] args) {
        // Input
        int n = 8;
        // Output
        int result = findNthCard(n);
        System.out.println(result);
    }
}

