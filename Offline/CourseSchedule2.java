class Solution {
    public int[] findOrder(int n, int[][] pre) {
         ArrayList<Integer> [] graph = new ArrayList[n];
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        int [] indegree = new int[n];
        for(int i  = 0; i < pre.length; i++){
            int [] edge =  pre[i];
            int a = edge[0];
            int b = edge[1];
            graph[b].add(a);
            indegree[a]++;
        }

        boolean [] vis = new boolean[n];

        LinkedList<Integer> q = new LinkedList<>();
        for(int i  = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.addLast(i);
            }
        }
        int cd = 0;
        int idx = 0;
        int [] ans = new int[n];
        while(q.size() != 0){
            int rem = q.removeFirst();
            ans[idx] = rem;
            idx++;
            ArrayList<Integer> nbrs = graph[rem];
            for(int nbr : nbrs){
                if(--indegree[nbr] == 0){
                    q.addLast(nbr);
                }
            }
        }


        if(idx != n){
            return new int[0];
        }

        return ans;

    }
}
