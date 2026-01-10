class Solution {

    int dp[][];

    public int topDownDp(String s1, String s2, int i, int j, int sum, int dp[][]){
        int m = s1.length();
        int n = s2.length();

        

        if(i == m && j == n){
            return 0;
        }
        else if(i == m){
            dp[i][j+1] = (int)s2.charAt(j) + topDownDp(s1,s2,i,j+1,sum,dp); 
            return dp[i][j+1];
        }
        else if(j == n){
            dp[i+1][j] = (int)s1.charAt(i) + topDownDp(s1,s2,i+1,j,sum,dp);
            return dp[i+1][j];
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        else{
            if(s1.charAt(i) == s2.charAt(j)){
                return dp[i][j] = sum + topDownDp(s1,s2,i+1,j+1,sum,dp);
            }
            int choice1 = sum + (int)s1.charAt(i) + topDownDp(s1,s2,i+1,j,sum,dp);
            int choice2 = sum + (int)s2.charAt(j) + topDownDp(s1,s2,i,j+1,sum,dp);

            int min = Math.min(choice1, choice2);


            return dp[i][j] = min;
        }
    }

    public int minimumDeleteSum(String s1, String s2) {
        
        int m = s1.length();
        int n = s2.length();

        dp = new int[m+1][n+1];
        // for(int i=0; i<m; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return topDownDp(s1,s2,0,0,0,dp);    
    }
}