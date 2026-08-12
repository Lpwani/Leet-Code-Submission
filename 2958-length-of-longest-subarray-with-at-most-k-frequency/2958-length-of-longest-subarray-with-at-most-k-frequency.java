class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> freq = new HashMap<>();

        int maxLen = 0;

        int i = 0, j = 0;

        while(j < n){
            freq.put(nums[j], freq.getOrDefault(nums[j], 0)+1);

            while(freq.get(nums[j]) > k){
                freq.put(nums[i], freq.get(nums[i])-1);
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);
            j++;
        }

        return maxLen;
    }
}