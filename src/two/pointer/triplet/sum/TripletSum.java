package two.pointer.triplet.sum;

import java.util.*;

public class TripletSum {

    public static ArrayList<ArrayList<Integer>> triplet_sum(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> triplets = new ArrayList<>();
        // Sort the input list.
        Collections.sort(nums);
        System.out.println("Sorted Array"+nums);
        for (int i = 0; i < nums.size(); i++) {
            // Optimization: triplets consisting of only positive numbers will never sum
            // to 0.
            if (nums.get(i) > 0) {
                break;
            }
            // To avoid duplicate triplets, skip 'a' if it's the same as the previous
            // number.
            if (i > 0 && nums.get(i).equals(nums.get(i - 1))) {
                continue;
            }
            // Find all pairs that sum to a target of '-a' ('-nums[i]').
            System.out.println("****"+nums.get(i));
            ArrayList<ArrayList<Integer>> pairs = pair_sum_sorted_all_pairs(nums, i + 1, -nums.get(i));
            for (ArrayList<Integer> pair : pairs) {
                ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(nums.get(i));
                triplet.addAll(pair);
                triplets.add(triplet);
            }
        }
        return triplets;
    }

    public static ArrayList<ArrayList<Integer>> pair_sum_sorted_all_pairs(ArrayList<Integer> nums, int start, int target) {
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();
        int left = start;
        int right = nums.size() - 1;
        while (left < right) {
            int sum = nums.get(left) + nums.get(right);
            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(nums.get(left));
                pair.add(nums.get(right));
                pairs.add(pair);
                left += 1;
                // To avoid duplicate '[b, c]' pairs, skip 'b' if it’s the same as the
                // previous number.
                while (left < right && nums.get(left).equals(nums.get(left - 1))) {
                    left += 1;
                }
            } else if (sum < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        return pairs;
    }
    public static void main(String[] args) {
        int[] arr = {0,0, -1, -1,2, -3,-3, 1};
        System.out.println("Input array: " + Arrays.toString(arr));

        ArrayList<Integer> nums = new ArrayList<>();
        for (int num : arr) {
            nums.add(num);
        }

        ArrayList<ArrayList<Integer>> triplets = triplet_sum(nums);

        if (triplets.isEmpty()) {
            System.out.println("No triplets found that sum to 0");
        } else {
            System.out.println("Triplets that sum to 0:");
            for (ArrayList<Integer> triplet : triplets) {
                System.out.println(triplet);
            }
        }
    }
}
