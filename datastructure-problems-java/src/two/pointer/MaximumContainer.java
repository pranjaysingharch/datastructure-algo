package two.pointer;

public class MaximumContainer {
    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int height = Math.min((heights[left]), (heights[right]));
            int width = right - left;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] height = {8, 7, 8, 3, 7, 6};
        System.out.println(maxArea(height));
    }
}
