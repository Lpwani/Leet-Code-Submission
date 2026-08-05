class Solution {

    // Time Complexity : O(n+m)
    // Space Complexity : O(n+m)

    public void dfs(int k, HashMap<Integer, ArrayList<Integer>> gp, int[] vis){
        vis[k] = 1;

        if(gp.containsKey(k)){
            for(int neighbour : gp.get(k)){
                if(vis[neighbour] == 0) dfs(neighbour, gp, vis);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        HashMap <Integer, ArrayList<Integer>> gp = new HashMap<>();
        ArrayList<Integer> rem = new ArrayList<>();

        for(int[] arr : invocations){
            // invocation : u --> v
            int u = arr[0];    
            int v = arr[1];

            if(gp.containsKey(u)){
                gp.get(u).add(v);
            }
            else if(!gp.containsKey(u)){
                ArrayList<Integer> neighbour = new ArrayList();
                neighbour.add(v);
                gp.put(u, neighbour);
            }
        }

        int vis[] = new int[n];

        dfs(k,gp,vis);

        for(int[] arr : invocations){
            int u = arr[0];
            int v = arr[1];

            if(vis[u] == 0 && vis[v] == 1){
                for(int i = 0; i < n; i++){
                    rem.add(i);
                }
                return rem;
            }
        }

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                rem.add(i);
            }
        }

        return rem;
    }
}