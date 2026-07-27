class Solution {
    public int maxProduct(int[] nums) {
        
        // optimized four magic number approach
        // time complexity = O(1)
        // Space complexity = O(1)

        int n = nums.length;

        int mx1 = Integer.MIN_VALUE, mx2 = Integer.MIN_VALUE;
        int mn1 = Integer.MAX_VALUE, mn2 = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int curr = nums[i];

            if(mx1 < curr){
                mx2 = mx1;
                mx1 = curr;
            }
            else if(mx2 < curr){
                mx2 = curr;
            }

            if(mn1 > curr){
                mn2 = mn1;
                mn1 = curr;
            }
            else if(mn2 > curr){
                mn2 = curr;
            }
        }

        return Math.max((mx1-1)*(mx2-1), (mn1-1)*(mn2-1));
    }
}