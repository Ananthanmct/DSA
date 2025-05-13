class Solution {
    
    
    public static void dfs(int vtx, boolean [] vis, Stack<Integer> st,  ArrayList<Integer> [] graph){
        vis[vtx] = true;
        ArrayList<Integer> nbrs = graph[vtx];
        for(int nbr : nbrs){
            if(vis[nbr] == false){
                dfs(nbr, vis, st, graph);
            }
        }
        st.push(vtx);
    }
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        
        ArrayList<Integer> [] graph = new ArrayList[V];
        for(int i = 0; i < V; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++){
            int [] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean [] vis = new boolean[V];
        
        for(int i = 0; i < graph.length; i++){
            if(vis[i] == false){
                dfs(i, vis, st, graph);
            }
        }
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(st.size() != 0){
            ans.add(st.pop());
        }
        
        return ans;
        
    }
}
