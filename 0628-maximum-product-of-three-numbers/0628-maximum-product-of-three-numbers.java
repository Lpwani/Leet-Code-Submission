class Solution {
    public int maximumProduct(int[] nums) {
        // observation based single pass optimized approach
        // 5 magic number approach
        // Time complexity = O(n)
        // Space Complexity = O(1)

        int n = nums.length;
        int mx1 = Integer.MIN_VALUE, mx2 = Integer.MIN_VALUE, mx3 = Integer.MIN_VALUE; 
        int mn1 = Integer.MAX_VALUE, mn2 = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int curr = nums[i];

            if(curr > mx1){
                mx3 = mx2;
                mx2 = mx1;
                mx1 = curr;
            }
            else if(curr > mx2){
                mx3 = mx2;
                mx2 = curr;
            }
            else if (curr > mx3){
                mx3 = curr;
            }

            if(curr < mn1){
                mn2 = mn1;
                mn1 = curr;
            }
            else if(curr < mn2){
                mn2 = curr;
            }
        }

        Arrays.sort(nums);

        // case 1 : three greatest number
        int case1Mul = mx1 * mx2 * mx3;

        // case 2 : 2 smallest negative number, one greatest positive number
        int case2Mul = mn1 * mn2 * mx1; 

        int ans = Math.max(case1Mul, case2Mul);

        return ans;

    }
}