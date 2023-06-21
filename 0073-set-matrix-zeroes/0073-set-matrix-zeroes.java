class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length; //number of rows
        int column = matrix[0].length; //number of columns
        
        int col0 =1;  //matrix[0][0] take twice to solve these problem take this extra variable
        
        //transverse the matrix and mark proper cells of 0th row and 0th column
        for(int i = 0; i<rows; i++){ 
            //if value at any 0th column is 0 then update col0=0
            if(matrix[i][0] ==0) col0=0;
            
            //travel remaning array
            for(int j = 1; j<column; j++){ //m=column 
                
                //if current=0 then update selected col and row of that matrix[i][j]
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        
       //Travels from backward  
        for(int i = rows-1; i>=0; i--){
            for(int j = column-1; j>=1; j--){
                //travels from last to 1st bcoz 0th column is depend on col0 variable
                //check if dummy value of 0th row and 0th column of current position 
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            //for 0th column check col0 variable 
            if (col0 == 0) {
                matrix[i][0] = 0; // ith row and 0th column=0 as matrix[0][0]=0 
              }

        }

    }
}
