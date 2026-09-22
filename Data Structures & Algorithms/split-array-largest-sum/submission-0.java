public class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int[] it : dp) {
            Arrays.fill(it, Integer.MAX_VALUE);
        }
        dp[n][0] = 0;

        for (int m = 1; m <= k; m++) {
            for (int i = n - 1; i >= 0; i--) {
                int curSum = 0;
                for (int j = i; j < n - m + 1; j++) {
                    curSum += nums[j];
                    dp[i][m] = Math.min(dp[i][m], Math.max(curSum, dp[j + 1][m - 1]));
                }
            }
        }

        return dp[0][k];
    }
}