class Solution {
    public int maxProduct(int[] nums) {
        
        // unoptimized whole array sort approach
        // time complexity = O(NlogN)
        // Space complexity = O(1)

        int n = nums.length;

        Arrays.sort(nums);

        return Math.max((nums[n-1]-1)*(nums[n-2]-1), (nums[0]-1)*(nums[1]-1));
    }
}