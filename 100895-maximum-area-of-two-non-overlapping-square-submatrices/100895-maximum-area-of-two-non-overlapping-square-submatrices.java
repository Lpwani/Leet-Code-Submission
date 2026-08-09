class Solution {
    public int maxArea(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int pref[][] = new int[m+1][n+1];

        for(int  i = 0; i < m ; i++){
            for(int j = 0; j < n ;j++){
                pref[i+1][j+1] = mat[i][j] + pref[i][j+1] + pref[i+1][j] - pref[i][j];
            }
        }

        int lo = 1;
        int hi = Math.min(m,n);

        int best = 0;

        while(lo <= hi){
            int k = lo + (hi - lo)/2;

            if(poss(k,m,n, pref)){
                best = k;
                lo = k + 1;
            }
            else{
                hi = k - 1;
            }
        }

        return best*best;
    }

    public boolean poss(int k, int m, int n, int[][] pref){
        int minRow = m;
        int maxRow = -1;

        int minCol = n;
        int maxCol = -1;

        for (int r = 0; r + k <= m; r++) {
            for (int c = 0; c + k <= n; c++) {

                if (getSum(r, c, k, pref) == k * k) {

                    minRow = Math.min(minRow, r);
                    maxRow = Math.max(maxRow, r);

                    minCol = Math.min(minCol, c);
                    maxCol = Math.max(maxCol, c);
                }
            }
        }


        if (maxRow == -1) {
            return false;
        }


        if (maxRow - minRow >= k) {
            return true;
        }

        if (maxCol - minCol >= k) {
            return true;
        }

        return false;
    }

    public int getSum(int r, int c, int k, int[][]pref){
        int r2 = r + k;
        int c2 = c + k;

        return pref[r2][c2] - pref[r][c2] - pref[r2][c] + pref[r][c];
    }
}