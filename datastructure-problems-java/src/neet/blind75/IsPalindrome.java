package neet.blind75;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String s = "0P";
        boolean result = isPalindrome(s);
        System.out.println("Is Palindrome: " + result);

}

    private static boolean isPalindrome(String s) {
        int left=0;
        int right =s.length()-1;
        while (left<right){
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
        }
            left++;
            right--;
        }
        return true;
    }
    }
