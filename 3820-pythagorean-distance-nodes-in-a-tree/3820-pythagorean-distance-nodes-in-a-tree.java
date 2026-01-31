class Solution {
    
    // optimized code
    // Time complexity :- O(N+M)

    public int[] bfs(int n, ArrayList<ArrayList<Integer>> graph, int x){

        int x_dist[] = new int[n];
        Queue <Integer>que = new LinkedList<Integer>();
        boolean visited[] = new boolean[n];


        Arrays.fill(x_dist, -1);

        x_dist[x] = 0;
        visited[x] = true;
        que.offer(x);

        while(!que.isEmpty()){
            int curr = que.poll();
            
                for(int i = 0; i < graph.get(curr).size(); i++){
                    if(visited[graph.get(curr).get(i)] == false){
                        visited[graph.get(curr).get(i)] = true;
                        que.offer(graph.get(curr).get(i));
                        x_dist[graph.get(curr).get(i)] = x_dist[curr]+1;
                    }
                }
                
        }

        return x_dist;
    }
        
    
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < n; i++){
            ArrayList <Integer>temp = new ArrayList<>();

            graph.add(temp);
        }

        int edg_len = edges.length;
        for(int i = 0; i < edg_len; i++){
            int a = edges[i][0];
            int b = edges[i][1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int x_dist[] = bfs(n, graph, x);
        int y_dist[] = bfs(n, graph, y);
        int z_dist[] = bfs(n, graph, z);

        int count = 0;

        for(int i = 0; i < n; i++){
            int dist[] = {x_dist[i], y_dist[i], z_dist[i]};

            Arrays.sort(dist);

            if(dist[0]*dist[0] + dist[1]*dist[1] == dist[2]*dist[2]){
                count++;
            }
        }

        return count;
        
    }
}