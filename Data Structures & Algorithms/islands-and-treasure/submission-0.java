class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid == null || grid.length==0){
            return;
        }

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==0){
                    queue.add(new int[]{r,c});
                }
            }
        }

        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] curr = queue.remove();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir:directions ){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc]==Integer.MAX_VALUE){
                    grid[nr][nc]=grid[r][c]+1;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
    }
}
