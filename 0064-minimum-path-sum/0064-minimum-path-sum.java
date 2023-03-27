class Solution {
    
    int solve(int[][] grid, int i, int j , int[][]dp ){
        if(i >= grid.length || j >= grid[0].length ) return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if( (i == grid.length-1) && (j == grid[0].length-1)) return grid[i][j];
        
        return dp[i][j]= grid[i][j]+Math.min( (solve(grid, i, j+1, dp)) ,(solve(grid, i+1, j, dp)) );
        
    }
    
    public int minPathSum(int[][] grid) {
        int [][]dp = new int[grid.length][grid[0].length];
        
        for(int []d:dp){
            Arrays.fill(d,-1);
        }
        return solve(grid, 0, 0, dp);
        
    }
    
}