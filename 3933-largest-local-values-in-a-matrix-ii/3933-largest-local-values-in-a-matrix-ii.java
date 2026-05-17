class Solution {
    public int countLocalMaximums(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        List<int[]>[]pos = new ArrayList[201];

        for(int i = 0; i <= 200; i++){
            pos[i] = new ArrayList<>();
        }

        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++){
                pos[matrix[i][j]].add(new int[]{i,j});
            }
        }

        int count = 0;

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                int x = matrix[row][col];
                if(x == 0) continue;

                boolean isLocalMax = true;

                for(int val = x +1; val <= 200 && isLocalMax; val++){
                    for(int[] p : pos[val]){
                        int r = p[0];
                        int c = p[1];

                        int rowDist = Math.abs(r-row);
                        int colDist = Math.abs(c- col);

                        if(rowDist <= x && colDist <= x){

                            if(rowDist == x && colDist ==x){
                                continue;
                            }

                            isLocalMax = false;
                            break;
                        }
                    }
                }

                if(isLocalMax){
                    count++;
                }
            }
        }
        
        return count;
    }
}