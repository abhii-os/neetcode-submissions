class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    int currentArea = dfs(grid,i,j);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][]grid,int r, int c){
        int area=0;
        int rows = grid.length;
        int cols = grid[0].length;
        if(r<0||r>=rows || c<0||c >=cols || grid[r][c]==0){
            return 0 ;
        }
        
            grid[r][c] = 0;

            int currentcellArea = 1;
            int up = dfs(grid,r-1,c);
            int down = dfs(grid,r+1,c);
            int left = dfs(grid,r,c-1);
            int right = dfs(grid,r,c+1);
        
        return currentcellArea + up + down+left+right;
    } 
    }

