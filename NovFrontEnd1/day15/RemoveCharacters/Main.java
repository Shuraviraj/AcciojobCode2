package NovFrontEnd1.day15.RemoveCharacters;

import java.util.Scanner;

class Solution {
    public static String removeChars(String S) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'a' || S.charAt(i) == 'c' || S.charAt(i) == 'i' || S.charAt(i) == 'o') continue;
            sb.append(S.charAt(i));
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        Solution obj = new Solution();
        String result = obj.removeChars(S);
        System.out.println(result);
    }
}
