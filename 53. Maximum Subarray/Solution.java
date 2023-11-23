class Solution {
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        int max = nums[0];
        memo[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            memo[i] = Math.max(nums[i] + memo[i - 1], nums[i]);
            max = Math.max(max, memo[i]);
        }

        return max;
    }
}