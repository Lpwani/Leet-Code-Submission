class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;

        int ansCnt = 0;

        int max = nums[0];
        for(int i = 0; i < n; i++){
            if(max < nums[i]){
                max = nums[i];
            }
        }

        for(int i = 0; i < n; i++){
            ansCnt += max - nums[i];
        }

        return ansCnt;
    }
}