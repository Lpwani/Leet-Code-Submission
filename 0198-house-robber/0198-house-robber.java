class Solution {

    public int maxLoot(int[] nums, int curr, int[] dp){
        if(curr >= nums.length) return 0;
        if(dp[curr] != -1) return dp[curr];

        return dp[curr] = Math.max((nums[curr]+maxLoot(nums,curr+2,dp)), maxLoot(nums, curr+1,dp));
    }

    public int rob(int[] nums) {
        
        // optimizzed DP solution
        // Time Complexity : O(N)
        // Space Complexity : O(N)

        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, -1);

        return maxLoot(nums, 0, dp);
    }
}