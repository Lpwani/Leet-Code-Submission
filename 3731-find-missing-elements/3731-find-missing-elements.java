class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        // Two pass approach
        // Space Complexity : O(max-min)
        // Time Complexity : O(n)

        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashSet<Integer> present = new HashSet<Integer>();

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE; 

        for(int i = 0; i < n; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);

            present.add(nums[i]);
        }

        for(int i = min; i <= max; i++){
            if(!present.contains(i)){
                ans.add(i);
            }
        }

        return ans;
    }
}