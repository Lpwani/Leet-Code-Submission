class Solution {

    int dp[][];
    public int distSubSeq(String s, String t, int i, int j){
        int n = s.length();
        int m = t.length();

        if(j == m) return 1;
        if(i >= n) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        // if(j == m-1 && s.charAt(i) == t.charAt(j)){
        //     return 1;
        //     // return;
        // }

        int ans = 0;

        // include
        if(s.charAt(i) == t.charAt(j)){
            ans += distSubSeq(s,t,i+1,j+1);
        }
        ans += distSubSeq(s,t,i+1,j);

        return dp[i][j] = ans;
    }

    public int numDistinct(String s, String t) {

        // time complexity : O(m*n)
        // Space complexity : O(m*n)

        int n = s.length();
        int m = t.length();

        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }


        distSubSeq(s,t,0,0);

        return dp[0][0];
    }
}