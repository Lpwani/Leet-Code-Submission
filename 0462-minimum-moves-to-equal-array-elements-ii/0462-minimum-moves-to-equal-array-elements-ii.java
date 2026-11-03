class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int median = (n%2 == 0)?((nums[n/2]+nums[n/2 - 1])/2):nums[n/2];
        int ansCnt = 0;

        System.out.println(median);

        for(int i = 0; i < n; i++){
            ansCnt += Math.abs(nums[i] - median);
        } 

        return ansCnt;


        // int sum = 0;
        // for(int i = 0; i < n; i++){
        //     sum += nums[i];
        // }

        // int avg = sum/n;
        // int cand1 = avg;
        // int cand2 = avg+1;

        // int numOpsCand1 = 0;
        // int numOpsCand2 = 0;

        // for(int i = 0; i < n; i++){
        //     numOpsCand1 += Math.abs(cand1 - nums[i]);
        //     numOpsCand2 += Math.abs(cand2 - nums[i]);
        // }

        // return Math.min(numOpsCand1, numOpsCand2);
    }
}