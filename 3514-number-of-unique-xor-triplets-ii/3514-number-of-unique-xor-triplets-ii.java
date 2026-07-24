class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
        // optimized approach
        // Time Complexity :- O(N^2)
        // Space Complexity :- O(N)

        int n = nums.length;

        int maxElm = 0;

        for(int i = 0; i < n; i++){
            maxElm = Math.max(maxElm, nums[i]);
        }

        int next2Pow = 1;
        while(next2Pow <= maxElm){
            next2Pow = next2Pow << 1;
        }

        boolean s1[] = new boolean[next2Pow];
        boolean s2[] = new boolean[next2Pow];

        for(int i = 0; i < n; i++){
            for(int j = i;j < n; j++){
                s1[nums[i] ^ nums[j]] = true;
            }
        }

        int cnt = 0;

        for(int i = 0; i < next2Pow; i++){
            if(s1[i] == true){
                for(int j = 0; j < n; j++){
                    if(s2[i ^ nums[j]] != true){
                        cnt++;
                        s2[i ^ nums[j]] = true;
                    }
                }
            } 
        }

        return cnt;
    }
}