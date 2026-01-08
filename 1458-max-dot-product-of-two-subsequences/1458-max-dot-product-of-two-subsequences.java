class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;

        int dp[][] = new int[m][n];


        int prev = nums1[0]*nums2[0];
        dp[0][0] = prev;
        for(int j = 1; j < n; j++){
            if(nums1[0]*nums2[j] > prev){
                prev = nums1[0]*nums2[j];
                dp[0][j] = prev;
            }
            else dp[0][j] = prev;
        }

        prev = nums1[0]*nums2[0];
        for(int i = 1; i < m; i++){
            if(nums1[i]*nums2[0] > prev){
                prev = nums1[i]*nums2[0];
                dp[i][0] = prev;
            }
            else dp[i][0] = prev;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int prod = nums1[i]*nums2[j];
                int up = dp[i-1][j];
                int left = dp[i][j-1];

                int diag = dp[i-1][j-1];
                if(diag < 0) diag = 0;
                
                dp[i][j] = Math.max(diag+prod,Math.max(up,left));
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[m-1][n-1];
    }
}