class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        // Time complexity : O(n^4)
        // Space complexity : O(n)

        HashMap<String,Integer> strOverlap = new HashMap<>();

        int n = img1.length;

        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(img1[i][j] == 1){
                    // StringBuilder sb = new StringBuilder();
                    for(int a = 0; a < n; a++){
                        for(int b = 0; b < n; b++){
                            if(img2[a][b] == 1){
                                StringBuilder sb = new StringBuilder();
                                int nums2row = a;
                                int nums2col = b;
                                while(nums2row-i > 0){
                                    sb.append('d');
                                    nums2row--;
                                }
                                while(nums2row-i < 0){
                                    sb.append('u');
                                    nums2row++;
                                }
                                while(nums2col-j > 0){
                                    sb.append('r');
                                    nums2col--;
                                }
                                while(nums2col-j < 0){
                                    sb.append('l');
                                    nums2col++;
                                }

                                strOverlap.put(sb.toString(), strOverlap.getOrDefault(sb.toString(),0)+1);
                            }
                        }
                    }
                }
            }
        }

        for(Map.Entry<String,Integer> entry : strOverlap.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();

            ans = Math.max(ans, val);
        }


        return ans;
    }
}