package neet.blind75;

public class ProductOfArrayItself {

    public static void main(String [] args) {
        System.out.println("Hello, World!");
        int[] nums = {1,2,4,6};
        int[] result = productExceptSelf(nums);
        for (int val : result) {
            System.out.print(val + " ");
        }

    }
    public static int[] productExceptSelf1(int[] nums) {
        int prod = 1, zeroCount = 0;
        for (int num : nums) {
            if (num != 0) {
                prod *= num;
            } else {
                zeroCount++;
            }
        }

        if (zeroCount > 1) {
            return new int[nums.length];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                res[i] = (nums[i] == 0) ? prod : 0;
            } else {
                res[i] = prod / nums[i];
            }
        }
        return res;
    }

    public static int[] productExceptSelf(int[] nums) {
        int product=1;
        int zeroCount=0;
        for(int num:nums){
            if(num!=0){
                product=product*num;
            }else{
                zeroCount++;
            }
        }
        if(zeroCount>1){
            return new int[nums.length];
        }
        int[] result=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(zeroCount>0){
                result[i]=(nums[i]==0)?product:0;
                continue;
            }
            result[i]=product/nums[i];
        }
        return result;

    }
}
