package leetcode.sliding_window;

public class P0643_MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        int windowSum = 0;

        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        P0643_MaximumAverageSubarrayI solver = new P0643_MaximumAverageSubarrayI();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println(solver.findMaxAverage(nums, k));
        // Expected output: 12.75
    }
}
