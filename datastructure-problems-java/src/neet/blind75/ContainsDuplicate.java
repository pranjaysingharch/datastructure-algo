package neet.blind75;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
   
        public boolean hasDuplicate(int[] nums) {
            Set<Integer> elements = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (elements.contains(nums[i])) {
                    return true;
                }
                elements.add(nums[i]);
            }
            return false;
        }

        public static void main(String[] args) {
            ContainsDuplicate cd = new ContainsDuplicate();
            int[] nums = {1, 2, 3, 4};
            System.out.println(cd.hasDuplicate(nums)); // Output: true
        }
    
}
