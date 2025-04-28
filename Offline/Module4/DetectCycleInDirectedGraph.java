public boolean dfs(ArrayList<Integer> [] graph, boolean [] vis, boolean [] pathVis, int src){
        pathVis[src] = true;
        vis[src] = true;
        ArrayList<Integer> nbrs = graph[src];
        for(int nbr : nbrs){
            if(pathVis[nbr] == true){
                return true;
            }else if(vis[nbr] == true){
                continue;
            }else{
                boolean isCyclic = dfs(graph, vis, pathVis, nbr);
                if(isCyclic){
                    return true;
                }
            }
        }
        pathVis[src] = false;
        return false;
    }
    
    
    
    
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        boolean [] vis = new boolean[V];
        ArrayList<Integer> [] graph = new ArrayList[V];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++){
            int [] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
        }
        
        boolean [] pathVis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                boolean isCycle = dfs(graph, vis, pathVis, i);
                if(isCycle){
                    return true;
                }
            }
        }
        
        return false;
        
        
    }
