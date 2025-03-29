class NumMatrix {

    int [][] arr;

    int [][] pSum;

    public void createPSum(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                // leftValue represents pSum[i][j-1]
                int leftValue = j > 0 ? pSum[i][j-1] : 0;
                int upValue = i > 0 ? pSum[i-1][j] : 0;
                int middleValue = (i>0 && j >0) ? pSum[i-1][j-1] :0;
                pSum[i][j] = leftValue + upValue - middleValue + arr[i][j];
            }
        }
    }


    public NumMatrix(int[][] matrix) {
        this.arr = matrix;
        this.pSum = new int[matrix.length][matrix[0].length];
        this.createPSum();
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int totalValue = pSum[row2][col2];
       
        int upValue = row1> 0 ? pSum[row1-1][col2] : 0;
        
        int leftValue = col1> 0 ? pSum[row2][col1-1] : 0;
        int middleValue = (row1> 0 && col1> 0) ? pSum[row1-1][col1-1] : 0;
        int ans = totalValue - upValue - leftValue + middleValue;
        
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */