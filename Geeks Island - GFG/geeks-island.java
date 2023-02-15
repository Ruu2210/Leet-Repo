//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public void solve(int row, int col, int[][] island, int[][] visited, int numRows, int numCols) {
        if (row < 0 || col < 0 || row >= numRows || col >= numCols || visited[row][col] == 1) {
            return;
        }
        visited[row][col] = 1;
        if (row > 0 && island[row-1][col] >= island[row][col]) {
            solve(row-1, col, island, visited, numRows, numCols);
        }
        if (row < numRows-1 && island[row+1][col] >= island[row][col]) {
            solve(row+1, col, island, visited, numRows, numCols);
        }
        if (col > 0 && island[row][col-1] >= island[row][col]) {
            solve(row, col-1, island, visited, numRows, numCols);
        }
        if (col < numCols-1 && island[row][col+1] >= island[row][col]) {
            solve(row, col+1, island, visited, numRows, numCols);
        }
    }

    public int water_flow(int[][] island, int numRows, int numCols) {
        int[][] toIndianOcean = new int[numRows][numCols];
        int[][] toArabianSea = new int[numRows][numCols];
        
        for (int i = 0; i < numRows; i++) {
            if (toIndianOcean[i][0] == 0) {
                solve(i, 0, island, toIndianOcean, numRows, numCols);
            }
        }
        
        for (int i = 0; i < numCols; i++) {
            if (toIndianOcean[0][i] == 0) {
                solve(0, i, island, toIndianOcean, numRows, numCols);
            }
        }
        
        for (int i = 0; i < numRows; i++) {
            if (toArabianSea[i][numCols-1] == 0) {
                solve(i, numCols-1, island, toArabianSea, numRows, numCols);
            }
        }
        
        for (int i = 0; i < numCols; i++) {
            if (toArabianSea[numRows-1][i] == 0) {
                solve(numRows-1, i, island, toArabianSea, numRows, numCols);
            }
        }
        
        int count = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (toIndianOcean[i][j] == 1 && toArabianSea[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}

