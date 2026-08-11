class Solution {
    public int missingInteger(int[] nums) {
        
        HashSet<Integer> pres = new HashSet<>();

        int maxLen = 1;
        int currMaxLen = 1;
        int currSeqSum = nums[0];
        int seqSum = nums[0];
        pres.add(nums[0]);

        int n = nums.length;

        boolean brk = false;

        for(int i = 1; i < n; i++){
            pres.add(nums[i]);
            if(nums[i] == (nums[i-1] + 1) && brk == false){
                currSeqSum += nums[i];
                System.out.println(currSeqSum);
            }
            else{
                brk = true;
            }
        } 

        // for(int i = 1; i < n; i++){
        //     pres.add(nums[i]);
        //     if(nums[i] == nums[i-1]+1){
        //         currMaxLen++;
        //         currSeqSum += nums[i];
        //     }
        //     else{
        //         currMaxLen = 1;
        //         currSeqSum = nums[i];
        //     }

        //     if(currMaxLen > maxLen){
        //         maxLen = currMaxLen;
        //         seqSum = currSeqSum;
        //     }else if(currMaxLen == maxLen){
        //         seqSum = Math.max(seqSum, currSeqSum);
        //     }
        // }

        int temp = currSeqSum;
        while(pres.contains(temp)){
            temp++;
        }

        return temp;
    }
}