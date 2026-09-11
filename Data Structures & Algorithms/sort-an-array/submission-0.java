 public class Solution {
    private void shellSort(int[] nums, int n) {
        int gap = n / 2;
        while (gap >= 1) {
            for (int i = gap; i < n; i++) {
                int tmp = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > tmp) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = tmp;
            }
            gap /= 2;
        }
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums;

        shellSort(nums, n);
        return nums;
    }
}