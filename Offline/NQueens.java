class Solution {
    
    // [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    
    List<List<String>> main = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

        boolean [][] board = new boolean[n][n];
        travelBoard(board, 0);
        return main;
        
    }
    
    public boolean isValidCell(boolean [][] board, int row, int col){
        int i = row;
        int j = col;
        
        while(i >= 0 && j >= 0){
            if(board[i][j] == true){
                return false;
            }
            i--;
            j--;
        }
        
        i = row;
        j = col;
        while(i >= 0){
            if(board[i][j] == true){
                return false;
            }
            i--;
        }
        
        i = row;
        j = col;
        
        while(i >= 0 && j < board.length){
            if(board[i][j] == true){
                return false;
            }
            i--;
            j++;
        }
        
        return true;
        
    }
    
    public void travelBoard(boolean [][] board, int row){
        
        if(row == board.length){
            List<String> config = new ArrayList<>();
            
            for(int i = 0; i < board.length; i++){
                String str = "";
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == true){
                        str += 'Q';
                    }else{
                        str += '.';
                    }
                }
                config.add(str);
            }
            
            main.add(config);
            return;
            
        }
        
        for(int col = 0; col < board[0].length; col++){
            if(isValidCell(board, row, col) == true){
                board[row][col] = true;
                travelBoard(board, row + 1);
                board[row][col] = false;
            }
        }
        
        
        
        
    }
}
