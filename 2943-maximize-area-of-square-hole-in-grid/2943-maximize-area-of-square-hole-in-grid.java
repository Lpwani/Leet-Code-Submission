class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        // n+1 = number of rows(1 to n+2)horizontar bars
        // m+1 = number of columns(1 to m+2)vertical bars

        // int a = Math.max(2, hBars.length);

        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int cnt_ver = 1;
        int max_cnt_ver = 1;
        for(int i = 1; i < vBars.length; i++){
            if(vBars[i] == vBars[i-1]+1){
                cnt_ver++;
                max_cnt_ver = Math.max(max_cnt_ver, cnt_ver);
            }
            else{
                cnt_ver = 1;
            }
        }

        max_cnt_ver = Math.max(max_cnt_ver, cnt_ver);

        System.out.println(max_cnt_ver);

        int cnt_hor = 1;
        int max_cnt_hor = 1;
        for(int i = 1; i < hBars.length; i++){
            if(hBars[i] == hBars[i-1]+1){
                cnt_hor++;
                max_cnt_hor = Math.max(max_cnt_hor,cnt_hor);
            }
            else{
                cnt_hor = 1;
            }
        }

        max_cnt_hor = Math.max(max_cnt_hor,cnt_hor);

        System.out.println(max_cnt_hor);

        int width = max_cnt_ver+1;
        int height = max_cnt_hor+1;

        int min = Math.min(width, height);

        return min*min;

    }
}