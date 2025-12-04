package neet.blind75;

import java.util.Arrays;

public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] nums = {100, 4, 200, 1,1, 3, 2};
        int result = longestConsecutive(nums);
        System.out.println("Longest Consecutive Length: " + result);
    }
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while (i < nums.length) {
            //Compare the current number with the expected number in the sequence
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            //Handle Duplicates
            while (i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }
}
