class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length; //number of rows
        int column = matrix[0].length; //number of columns
        
        int col0 =1;  //matrix[0][0] take twice to solve these problem take this extra variable
        
        //transverse the matrix and mark proper cells of 0th row and 0th column
        for(int i = 0; i<rows; i++){ //n=row
            if(matrix[i][0] ==0) col0=0;
            for(int j = 1; j<column; j++){ //m=column 
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        
       //according to 0th row and 0th column mark all other 
        for(int i = rows-1; i>=0; i--){
            for(int j = column-1; j>=1; j--){
                //if in given matrix[i][j] any 0th row or column is 0 mark given place=0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
                
            }
            if (col0 == 0) {
                matrix[i][0] = 0; // ith row and 0th column=0 as matrix[0][0]=0 
              }

        }

    }
}