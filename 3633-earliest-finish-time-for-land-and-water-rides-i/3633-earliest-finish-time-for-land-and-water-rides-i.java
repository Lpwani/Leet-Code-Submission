class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int n = landStartTime.length;
        int m = waterStartTime.length;

        int ans = Integer.MAX_VALUE;
        // case 1: 1st --> 2nd
        int initLow = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            initLow = Math.min(initLow, landStartTime[i]+landDuration[i]);
        }

        int perTemp = Integer.MAX_VALUE; 
        for(int i = 0; i < m; i++){
            int tmp = Integer.MAX_VALUE;
            if(initLow >= waterStartTime[i]){
                tmp = Math.min(tmp, initLow + waterDuration[i]);
            }
            else{
                tmp = Math.min(tmp,waterStartTime[i]+waterDuration[i]);
            }
            perTemp = Math.min(tmp,perTemp);
        }
        // ans = Math.min(ans, perTemp);

        // case 2: 2nd -> 1st

        int initLow1 = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            initLow1 = Math.min(initLow1, waterStartTime[i]+waterDuration[i]);
        }

        int perTemp1 = Integer.MAX_VALUE; 
        for(int i = 0; i < n; i++){
            int tmp = Integer.MAX_VALUE;
            if(initLow1 >= landStartTime[i]){
                tmp = Math.min(tmp, initLow1 + landDuration[i]);
            }
            else{
                tmp = Math.min(tmp,landStartTime[i]+landDuration[i]);
            }
            perTemp1 = Math.min(tmp,perTemp1);
        }
        ans = Math.min(perTemp1, perTemp);

        return ans;
    }
}