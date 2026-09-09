class Solution {
    public long countCommas(long n) {
        
        long ans = 0;
        long lmt[] = {1000l, 1000000l, 1000000000l,1000000000000l, 1000000000000000l};

        int currComma = 1;
        for(int i = 0; i < lmt.length; i++){
            if(n < lmt[i]) break;
            
            ans += (n-lmt[i]+1)*currComma;
        }

        return ans;
    }
}