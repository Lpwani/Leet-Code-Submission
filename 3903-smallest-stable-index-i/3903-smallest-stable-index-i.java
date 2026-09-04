class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        // Three pass approach
        // can be optimized further

        // Time complexity : O(N)
        // Space complexity: O(N)

        int  n = nums.length;

        int minVal[] = new int[n];
        int maxVal[] = new int[n];

        int mx = -1;
        int mn = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            mx = Math.max(mx,nums[i]);
            maxVal[i] = mx;
        }

        for(int i = n-1; i >= 0; i--){
            mn = Math.min(mn,nums[i]);
            minVal[i] = mn;
        }

        int ans = -1;

        for(int i = 0; i < n; i++){
            if((maxVal[i] - minVal[i]) <= k){
                ans = i;
                break;
            }
        }

        return ans;
    }
}