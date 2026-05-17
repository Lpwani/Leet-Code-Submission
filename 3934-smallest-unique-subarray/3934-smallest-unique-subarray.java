class Solution {
    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        int low = 1;
        int high = n;

        int ans = n;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(hasUnique(nums,mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean hasUnique(int[] nums, int len){

        int n = nums.length;

        // longest base for hash function
        long base = 911382323L;
        long mod = 1000000007L;

        long hash = 0;
        long power = 1;

        for(int i = 0; i < len; i++){
            hash = (hash * base + nums[i]) % mod;

            if(i < len - 1){
                power = (power * base) % mod;
            }
        }

        Map<Long,Integer> freq = new HashMap<>();

        freq.put(hash, 1);

        for(int i = len; i < n; i++){
            hash = (hash - nums[i - len] * power % mod + mod) %mod;
            hash = (hash * base + nums[i]) % mod;

            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }

        for(int count : freq.values()){
            if(count == 1){
                return true;
            }
        }

        return false;
    }
}