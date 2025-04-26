class Solution {

  //https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
    
    public void dfs(ArrayList<Integer> [] graph, int src, boolean [] vis, ArrayList<Integer> cvList){
        vis[src] = true;
        cvList.add(src);
        ArrayList<Integer> nbrs = graph[src];
        for(int nbr : nbrs){
            if(vis[nbr] == false){
                dfs(graph, nbr, vis, cvList);
            }
        }
    }
    
    
    
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
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
            graph[v].add(u);
        }
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                ArrayList<Integer> cvList = new ArrayList<>();
                dfs(graph, i, vis, cvList);
                ans.add(cvList);
            }
        }
        
        return ans;
        
        
    }
}
