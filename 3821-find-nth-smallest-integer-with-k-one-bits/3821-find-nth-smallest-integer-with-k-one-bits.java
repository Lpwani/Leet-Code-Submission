class Solution {
    public long nthSmallest(long n, int k) {
        
        long comb[][] = new long[51][51];

        for(int i = 0; i < 51; i++){
            Arrays.fill(comb[i], 0);
        }

        for(int i = 0; i <= 50; i++){
            comb[i][0] = 1;
            for(int j = 1; j <= i; j++){
                comb[i][j] = comb[i-1][j-1] + comb[i-1][j];
            }
        }

        long ans = 0;

        for(int i = 50; i >= 0; i--){
            long val = comb[i][k];
            if(val < n){
                n = n - val;
                k--;
                ans = ans|(1L <<i);
            }
        }

        return ans;
    }
}