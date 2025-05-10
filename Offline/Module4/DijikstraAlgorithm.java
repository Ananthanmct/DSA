class Solution {
    public class Edge{
        int nbr;
        int wt; // Edge Weight
        public Edge(int nbr, int wt){
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    
    public class Pair{
        int vtx; 
        int wsf;// Total sum of all the edges from source vertex to this ctx;
        public Pair(int vtx, int wsf){
            this.vtx = vtx;
            this.wsf = wsf;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
      ArrayList<Edge> [] graph = new ArrayList[V];
      for(int i  = 0; i < V; i++){
          graph[i] = new ArrayList<>();
      }
      // Travel over the edges array and make your graph. 
      for(int e = 0; e < edges.length; e++){
          int [] edge = edges[e];
          int u = edge[0];
          int v = edge[1];
          int wt = edge[2];
          // U -> v , V -> u
          graph[u].add(new Edge(v, wt));
          graph[v].add(new Edge(u, wt));
      }
      
      int [] dist = new int[V];
      Arrays.fill(dist, -1);
      PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wsf - b.wsf);
      pq.add(new Pair(src, 0));
      
      while(pq.size() !=  0){
          Pair rem = pq.remove();
          if(dist[rem.vtx] != -1){
              continue;
          }
          dist[rem.vtx] = rem.wsf;

          ArrayList<Edge> nbrs = graph[rem.vtx];
          for(Edge e : nbrs){
              int nbr = e.nbr;
              int edgWt = e.wt;
              if(dist[e.nbr] == -1){
                  pq.add(new Pair(nbr, rem.wsf + edgWt));
              }
          }
      }
      
      return dist;
      
    }
}
