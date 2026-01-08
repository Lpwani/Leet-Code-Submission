class Solution {
    public long maxMatrixSum(int[][] matrix) {
        
        int negCnt = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        // negFlg(false) = even
        // negFlg(true) = odd
        int zeroCnt = 0;
        boolean negFlg = false;
        int maxNeg = Integer.MAX_VALUE;

        long sum = 0;

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] < 0){
                    negFlg = !negFlg;
                }

                maxNeg = Math.min(maxNeg, Math.abs(matrix[i][j]));

                if(matrix[i][j] == 0){
                    zeroCnt++;
                }
            }
        }

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                sum += Math.abs(matrix[i][j]);
            }
        }

        System.out.println(maxNeg);
        System.out.println(sum);

        if(zeroCnt > 0 || negFlg == false){
            return sum;
        }
        else if(negFlg == true){
            return sum - 2*maxNeg;
        }
        return sum;
    }
}