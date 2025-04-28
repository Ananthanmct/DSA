class Solution {
    
    int [][] dir =  {{-1, 0}, 
                    {0, 1}, 
                    {1, 0}, 
                    {0, -1}};

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        
        
        HashSet<String> set = new HashSet<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder psf = new StringBuilder();
                    dfs(i, j, grid, psf);
                    set.add(psf.toString());
                }
            }
        }
            
        return set.size();
        
    }
    
    
    public void dfs(int sr, int sc, int [][] grid, StringBuilder psf){
        
        grid[sr][sc] = 0;
        
        
        for(int d = 0; d < dir.length; d++){
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1]; 
            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] != 0){
                psf.append(d);
                dfs(nr, nc, grid,psf);
            }
        }
    
        psf.append("#");
        
        
    }
    
    
    
    
    
    
    
    
}
