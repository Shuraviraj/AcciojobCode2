package NovFrontEnd1.day14.Recursivelyremoveallduplicates;

import java.util.Scanner;

class Solution {
    public static String removeDuplicates(String s) {
        return f(s);
    }

    private static String f(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            if (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
            if (j - i > 1) i = j;
            else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        if (sb.length() == s.length()) return sb.toString();
        else return f(sb.toString());
    }

}

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution Obj = new Solution();
        System.out.println(Obj.removeDuplicates(str));
    }
}
