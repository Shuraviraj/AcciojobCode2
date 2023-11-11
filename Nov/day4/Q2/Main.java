package Nov.day4.Q2;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
//    public List<List<Integer>> findPotions(int[] ingredients, int correctAmt) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> cur = new ArrayList<>();
//        recur(ans, cur, ingredients, correctAmt, 0, 0);
//        return ans;
//    }
//
//    void recur(List<List<Integer>> ans, List<Integer> cur, int[] ing, int reqAmt, int idx, int sumTillNow) {
//        if (sumTillNow > reqAmt || idx > ing.length - 1) return;
//        if (sumTillNow == reqAmt) {
//            ans.add(new ArrayList<>(cur));
//            return;
//        }
//        //take me
//        cur.add(ing[idx]);
//        recur(ans, cur, ing, reqAmt, idx, sumTillNow + ing[idx]);
//        cur.remove(cur.size() - 1);
//
//        // skip me
//        recur(ans, cur, ing, reqAmt, idx + 1, sumTillNow);
//    }

    public List<List<Integer>> findPotions(int[] ingredients, int correctAmt) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        recur(ans, cur, ingredients, correctAmt, 0, 0, new HashMap<>());
        return ans;
    }

    void recur(List<List<Integer>> ans, List<Integer> cur, int[] ing, int reqAmt, int idx, int sumTillNow, Map<String, List<List<Integer>>> memo) {
        if (sumTillNow == reqAmt) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        if (idx >= ing.length || sumTillNow > reqAmt) {
            return;
        }

        // Check if the result for the current state is already computed
        String state = idx + "," + sumTillNow;
        if (memo.containsKey(state)) {
            for (List<Integer> combination : memo.get(state)) {
                List<Integer> copy = new ArrayList<>(combination);
                copy.addAll(cur);
                ans.add(copy);
            }
            return;
        }

        // Take the current ingredient
        cur.add(ing[idx]);
        recur(ans, cur, ing, reqAmt, idx, sumTillNow + ing[idx], memo);
        cur.remove(cur.size() - 1);

        // Skip the current ingredient
        recur(ans, cur, ing, reqAmt, idx + 1, sumTillNow, memo);

        // Store the result in the memoization table
        memo.putIfAbsent(state, new ArrayList<>());
        memo.get(state).add(new ArrayList<>(cur));
    }
}

public class Main {
    public static Comparator<List<Integer>> comparator = (x, y) -> {
        for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
            if (x.get(i) != y.get(i)) {
                return x.get(i) - y.get(i);
            }
        }
        return Integer.compare(x.size(), y.size());
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int correctAmt = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> result = Obj.findPotions(arr, correctAmt);
        result.sort(comparator);
        result.stream().map(l -> {
            Collections.sort(l, Comparator.naturalOrder());
            return l;
        }).collect(Collectors.toList());
        for (List<Integer> inner : result) {
            Integer[] innerArr = inner.toArray(new Integer[inner.size()]);
            for (int i = 0; i < innerArr.length; i++)
                System.out.print(innerArr[i] + " ");
            System.out.println();
        }
        sc.close();
    }
}