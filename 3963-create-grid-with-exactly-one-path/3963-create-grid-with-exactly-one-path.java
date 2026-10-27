class Solution {
    public String[] createGrid(int m, int n) {
        
        int rowPtr = 0;
        int colPtr = 0;

        int currAct = 0;

        char [][] tempAns = new char[m][n];

        while(rowPtr < m && colPtr < n){
            if(currAct == 0){
                tempAns[rowPtr][colPtr] = '.';
                colPtr++;
                currAct = (currAct+1)%2;
            }
            else{
                tempAns[rowPtr][colPtr] = '.';
                rowPtr++;
                currAct = (currAct+1)%2;
            }
        }

        if(colPtr == n && rowPtr != m){
            colPtr = colPtr - 1;

            while(rowPtr < m-1){
                tempAns[++rowPtr][colPtr] = '.';
            }
        }
        else if(rowPtr == m && colPtr != n){
            rowPtr = rowPtr - 1;

            while(colPtr < n-1){
                tempAns[rowPtr][++colPtr] = '.';
            }
        }
        

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(tempAns[i][j] != '.') tempAns[i][j] = '#';
            }
        }
        
        String ans[] = new String[m];

        for(int i = 0; i < m; i++){
            ans[i] = new String(tempAns[i]);
        }

        return ans;
    }
}