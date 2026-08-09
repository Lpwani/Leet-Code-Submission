class Solution {
    public long weightedSum(int[] parent, int[] nums) {

        int n = parent.length;

        long ans = 0;
        
        int hd[] = new int[n]; 
        int nt[] = new int[n];

        java.util.Arrays.fill(hd,-1);

        for(int  i = 1; i < n; i++){
            nt[i] = hd[parent[i]];
            hd[parent[i]] = i; 
        }

        int depth[] = new int[n];
        int stack[] = new int[n];

        int tp =0;
        stack[tp] = 0;
        tp++;
        depth[0] = 1;

        int height = 1;

        while(tp > 0){
            int node = stack[--tp];

            for(int  child = hd[node]; child != -1; child = nt[child]){
                depth[child] = depth[node] + 1;
                height = Math.max(height, depth[child]);

                stack[tp++] = child;
            }
        }
        
        
        for(int  i = 0; i < n; i++){
            ans += ((long)nums[i]*(height - depth[i] + 1));
        }

        return ans;
    }
}