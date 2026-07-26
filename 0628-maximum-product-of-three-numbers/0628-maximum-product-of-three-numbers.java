class Solution {
    public int maximumProduct(int[] nums) {
        // observation based optimized approach
        // Time complexity = O(1)
        // Space Complexity = O(1)

        int ans = Integer.MIN_VALUE;
        int n = nums.length;

        Arrays.sort(nums);

        // case 1 : all three greatest number
        int case1Mul = nums[n-1] * nums[n-2] * nums[n-3];

        // case 2 : 2 smallest negative number, one greatest positive number
        int case2Mul = nums[0] * nums[1] * nums[n-1]; 

        ans = Math.max(case1Mul, case2Mul);

        return ans;

    }
}