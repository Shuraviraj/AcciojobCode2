package NovFrontEnd1.day15.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static List<Integer> subsetA(List<Integer> arr) {
        int sumB = 0;
        for (int i = 0; i < arr.size(); i++) {
            sumB += arr.get(i);
        }
        Collections.sort(arr, Collections.reverseOrder());
        int sumA = 0;
        List subsetA = new ArrayList<>();
        for (int num : arr) {
            if (sumA <= sumB) {
                subsetA.add(num);
                sumA += num;
                sumB -= num;
            } else break;
        }
        Collections.sort(subsetA);
        return subsetA;
    }

    private static void reverseArray(Integer[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 2, 5, 1, 6);
        List<Integer> result = subsetA(arr);

        System.out.println(result);
    }

}
