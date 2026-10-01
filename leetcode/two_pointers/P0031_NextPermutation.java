package leetcode.two_pointers;

public class P0031_NextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n - 2;

        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        if (pivot >= 0) {
            int swapCandidate = n - 1;

            while (nums[swapCandidate] <= nums[pivot]) {
                swapCandidate--;
            }

            swap(nums, pivot, swapCandidate);
        }

        reverse(nums, pivot + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        P0031_NextPermutation solver = new P0031_NextPermutation();
        int[] nums = {1, 3, 5, 4, 2};

        solver.nextPermutation(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Expected output: 1 4 2 3 5
    }
}
