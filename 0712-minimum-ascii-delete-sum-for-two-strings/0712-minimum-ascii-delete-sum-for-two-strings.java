class Solution {

    int dp[][];

    public int topDownDp(String s1, String s2, int i, int j){
        int m = s1.length();
        int n = s2.length();

        // Best Case
        if(i == m && j == n){
            return 0;
        }

        // Reuse
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // if s1 is exhausted
        if(i == m){
            return dp[i][j] = (int)s2.charAt(j) + topDownDp(s1,s2,i,j+1); 
        }

        // if s2 is exhausted
        if(j == n){
            return dp[i][j] = (int)s1.charAt(i) + topDownDp(s1,s2,i+1,j);
            
        }
        
        // character matching
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = topDownDp(s1,s2,i+1,j+1);
        }

        // delete from either string
        int deleteS1 = (int)s1.charAt(i) + topDownDp(s1,s2,i+1,j);
        int deleteS2 = (int)s2.charAt(j) + topDownDp(s1,s2,i,j+1);

        int min = Math.min(deleteS1, deleteS2);


        return dp[i][j] = min;
    
    }

    public int minimumDeleteSum(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();

        dp = new int[m+1][n+1];

        for(int i = 0; i < dp.length; i++){
            Arrays.fill(dp[i],-1);
        }

        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return topDownDp(s1,s2,0,0);    
    }
}