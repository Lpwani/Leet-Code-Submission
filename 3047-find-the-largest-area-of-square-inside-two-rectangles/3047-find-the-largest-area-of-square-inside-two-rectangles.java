class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        
        int n = bottomLeft.length;

        long max_side = 0;

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                int width = Math.min(topRight[j][0], topRight[i][0]) - Math.max(bottomLeft[j][0],bottomLeft[i][0]);
                int height = Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                int side = Math.min(width,height);
                max_side = Math.max(max_side,side);

                // long area = (long)side * side
                // ans = Math.max(ans, area);
            }
        }

        return max_side*max_side;
    }
}