package two.pointer;

public class ShiftZeroToEnd {
    public static void shiftZerosToEnd(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }
    }
    public static void main(String []args){
        int[] nums = {0, 1, 0, 3, 2};
        shiftZerosToEnd(nums);
        System.out.println(java.util.Arrays.toString(nums)); // [1, 3, 2, 0, 0]
    }

}
