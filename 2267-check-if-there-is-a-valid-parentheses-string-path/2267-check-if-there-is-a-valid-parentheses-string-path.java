class Solution {

    // Boolean t[][][];

    // public boolean validPath(char[][] grid, int row, int col, int currVal){

    //     if(row > grid.length - 1 || col > grid[0].length - 1) return t[row][col][currVal] = false;

    //     if(t[row][col][currVal] != null) return t[row][col][currVal];

    //     currVal = (grid[row][col] == '(')?currVal+1:currVal-1;

    //     if(currVal < 0) return false;
    //     if(row == grid.length - 1 && col == grid[0].length - 1 && currVal == 0) return t[row][col][currVal] = true;

    //     boolean right = validPath(grid, row, col+1, currVal);

    //     boolean notRight = validPath(grid, row+1, col, currVal);

    //     return t[row][col][currVal] = right || notRight;
    // }

    // 0 = unvisited, 1 = true (valid path), 2 = false (invalid path)
    int t[][][];

    public boolean validPath(char[][] grid, int row, int col, int currVal){
        // 1. Safe out-of-bounds check (Return false immediately without touching the array)
        if(row >= grid.length || col >= grid[0].length) {
            return false;
        }

        // 2. Track bracket balance changes
        currVal = (grid[row][col] == '(') ? currVal + 1 : currVal - 1;

        // 3. Early Pruning: If closing brackets exceed opening brackets, it's invalid
        if(currVal < 0) {
            return false;
        }

        // 4. Return cached result if already calculated
        if(t[row][col][currVal] != 0) {
            return t[row][col][currVal] == 1;
        }

        // 5. Destination Check: Must reach bottom-right with a perfectly balanced count (0)
        if(row == grid.length - 1 && col == grid[0].length - 1) {
            boolean isValidEnd = (currVal == 0);
            t[row][col][currVal] = isValidEnd ? 1 : 2;
            return isValidEnd;
        }

        // 6. Explore Down and Right paths
        boolean right = validPath(grid, row, col + 1, currVal);
        boolean down = validPath(grid, row + 1, col, currVal);
        
        boolean result = right || down;

        // 7. Save the result to the cache and return it
        t[row][col][currVal] = result ? 1 : 2;
        return result;
    }


    public boolean hasValidPath(char[][] grid) {
        // not optimized solution
        // naive recursion solution

        // Time complexity :- 2^(m+n)
        // Space complexity :- m+n

        t = new int[101][101][201];

        // for(int i = 0; i < 101; i++){
        //     for(int j = 0; j < 101; j++){
        //         Arrays.fill(t[i][j], -1);
        //     }
        // }

        boolean ans = validPath(grid, 0, 0, 0);

        return ans;
    }
}