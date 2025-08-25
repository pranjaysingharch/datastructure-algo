package two.pair.sum.sorted;

import java.util.ArrayList;
import java.util.List;
/**
 * Finds all pairs of indices in a sorted array whose elements sum up to the targetSum using the two-pointer technique.
 *
 * Time Complexity: O(n)
 *   - The method uses two pointers that traverse the array from both ends.
 *   - Each pointer moves at most n times, resulting in linear time.
 *
 * Space Complexity: O(k)
 *   - Where k is the number of pairs found.
 *   - The method stores each valid pair in a list.
 *
 * @param arr the sorted input array of integers
 * @param targetSum the target sum to find pairs for
 * @return a list of integer arrays, each containing a pair of indices
 */
public class PairSumSortedOptimized {
    public static List<int[]> hasPairWithSum(int[] arr, int targetSum) {

        List<int[]> pairs = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum < targetSum) {
                left++;
            } else if (currentSum > targetSum) {
                right--;
            } else {
                pairs.add(new int[]{left, right});
                left++;
                right--;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] arr = {-5, -2, 3, 4, 6};
        int targetSum = 1;
        List<int[]> pairs = hasPairWithSum(arr, targetSum);
        if (pairs.isEmpty()) {
            System.out.println("No pairs found.");
        } else {
            for (int[] pair : pairs) {
                System.out.println("Pair found at indices: " + pair[0] + ", " + pair[1]);
            }
        }


    }
}
