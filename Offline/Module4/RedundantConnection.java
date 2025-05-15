class Solution {
    int [] par;
    public int find(int vtx){
        if(vtx == par[vtx]){
            return vtx;
        }
        int fPar = find(par[vtx]);
        return fPar;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            par[i] = i;
        }

        for(int i = 0; i < edges.length; i++){
            int [] edge = edges[i];
            int vtx1 = edge[0];
            int vtx2 = edge[1];
            int parVtx1 = find(vtx1);
            int parVtx2 = find(vtx2);
            if(parVtx1 != parVtx2){
                par[parVtx1] = parVtx2;
            }else{
                return edge;
            }
        }
        int [] neg = {-1, -1};
        return neg;

    }
}
