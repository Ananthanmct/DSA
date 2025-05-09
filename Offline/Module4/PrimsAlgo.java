class Solution {
    public static class Edge{
        int src;
        int nbr;
        int wt;
        public Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> graph) {
      PriorityQueue<Edge> pq = new PriorityQueue<Edge>((a, b) -> a.wt - b.wt);
      pq.add(new Edge(0, 0, 0));
      int overAllWt = 0;
      boolean [] vis = new boolean[V];
      while(pq.size() != 0){
          // remove 
          Edge e = pq.remove();
          int nbr = e.nbr;
          if(vis[nbr] == true){
              continue;
          }
          vis[nbr] = true;
          overAllWt += e.wt;
          List<int []> nbrs = graph.get(nbr);
          for(int [] newNbrs : nbrs){
              int destNbr = newNbrs[0];
              int wt = newNbrs[1];
              if(vis[destNbr] == false){
                  pq.add(new Edge(nbr, destNbr, wt));
              }
          }
      }
      return overAllWt;
      
    }
}
