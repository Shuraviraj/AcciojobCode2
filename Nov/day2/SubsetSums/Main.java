package Nov.day2.SubsetSums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Solution {
    public ArrayList<Integer> SubsetSums(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        recur(arr, 0, 0, ans);
        return ans;
    }

    private void recur(ArrayList<Integer> arr, int i, int sum, ArrayList<Integer> ans) {
        if (i == arr.size()) {
            ans.add(sum);
            return;
        }
        //pickme
        recur(arr, i + 1, sum + arr.get(i), ans);

        //leave me
        recur(arr, i + 1, sum, ans);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(sc.nextInt());
        Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.SubsetSums(arr);
        Collections.sort(ans);
        for (int a : ans)
            System.out.print(a + " ");

    }
}