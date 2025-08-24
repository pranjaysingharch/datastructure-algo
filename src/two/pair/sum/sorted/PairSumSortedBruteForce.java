package two.pair.sum.sorted;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Finds all pairs of indices in the array whose elements sum up to the targetSum.
 * <p>
 * Time Complexity: O(n^2)
 * - The method uses two nested loops, each iterating over the array.
 * - For each element, it checks every subsequent element, resulting in n*(n-1)/2 comparisons.
 * <p>
 * Space Complexity: O(k)
 * - Where k is the number of pairs found.
 * - The method stores each valid pair in a list.
 *
 * @param arr       the input array of integers
 * @param targetSum the target sum to find pairs for
 * @return a list of integer arrays, each containing a pair of indices
 */
class PairSumSortedBruteForce {
    public static List<int[]> hasPairWithSum(int[] arr, int targetSum) {
        int n = arr.length;
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    pairs.add(new int[]{i, j});
                }
            }
        }
        return pairs;
    }

    public static List<int[]> hasPairWithSumWithLambda(int[] arr, int targetSum) {
        int n = arr.length;
        return IntStream.range(0, n)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, n)
                        .filter(j -> arr[i] + arr[j] == targetSum)
                        .mapToObj(j -> new int[]{i, j}))
                .collect(Collectors.toList());
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
        List<int[]> lambdaPairs = hasPairWithSumWithLambda(arr, targetSum);
        if (pairs.isEmpty()) {
            System.out.println("No pairs found.");
        } else {
            for (int[] pair : lambdaPairs) {
                System.out.println("Pair found at indices: " + pair[0] + ", " + pair[1]);
            }
        }
    }
}
