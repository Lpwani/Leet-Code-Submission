class Solution {

    private long pow9(int p){
        long ans = 1;
        while(p-- > 0) ans *= 9;
        return ans;
    }
    public long countDistinct(long n) {
        
        long temp = n;

        int currPow = 0;
        long currDist = 0;

        while(temp != 0){
            String s = String.valueOf(n);
            int len = s.length();
            long result = 0;

            for(int i = 1; i < len; i++){
                result += pow9(i);
            }

            for(int i =0; i < len; i++){
                int digit = s.charAt(i) - '0';

                if(digit == 0) return result;
                
                int choices = digit - 1;
                result += (digit - 1)*pow9(len - i -1);
            }

            return result+1;
        }

        return currDist;
    }
}


// while(temp/10 != 0){
        //     int currMultiplier = temp/10;
        //     temp = temp-((10^curr10pow)*currMultiplier);
            
        // }
        // currDist += temp;