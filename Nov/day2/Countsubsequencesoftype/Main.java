package Nov.day2.Countsubsequencesoftype;

import java.util.Scanner;

class Solution {
    static int pcc = 0;

    public static int fun(String s) {
//        return recur(s, 0, new StringBuilder());
        return tab(s);
    }

    private static int tab(String s) {
        int prevA = 0, prevB = 0, prevC = 0, md = (int) 1e9 + 7;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a': {
                    prevA = ((2 * prevA) % md + 1 % md) % md;
                    break;
                }
                case 'b': {
                    prevB = ((2 * prevB) % md + prevA % md) % md;
                    break;
                }
                case 'c': {
                    prevC = ((2 * prevC) % md + prevB % md) % md;
                    break;
                }
            }
        }
        return prevC % md;
    }

    private static int recur(String s, int i, StringBuilder sb) {
        if (i == s.length()) {
            int[] x = new int[3];
            int c = 0;
            for (int j = 0; j < sb.length(); j++) {
                int idx = sb.charAt(j) - 'a';
                if (x[idx] == 0) {
                    x[idx] = 1;
                    c++;
                }
            }
            return c == 3 ? 1 : 0;
        }
        sb.append(s.charAt(i));
        int pickMe = recur(s, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        int notPickMe = recur(s, i + 1, sb);

        return pickMe + notPickMe;
    }

}

/* Name of the class has to be "Main" only if the class is public. */
class Main {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.print(Solution.fun(s));

    }
}
