class Solution {
    public int orangesRotting(int[][] grid) {
     if(grid.length==0||grid==null){
        return -1;
     }   
     int rows = grid.length;
     int cols = grid[0].length;
     Queue<int[]> queue = new ArrayDeque<>();
     int freshCount =0;

     for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(grid[i][j]==2){
                queue.add(new int[] {i,j});
            }
            else if(grid[i][j]==1){
                freshCount++;
            }
        }
     }
    if(freshCount == 0){
        return 0;
    }
    int minutes = 0;
    int[][] directions  = {{-1,0},{1,0},{0,1},{0,-1}};
   
    while(!queue.isEmpty() && freshCount>0){
        int size = queue.size();
        for(int k=0;k<size;k++){
        int[] curr = queue.poll();
        for(int[] dir:directions){
            int nr = curr[0]+dir[0];
            int nc = curr[1]+dir[1];

            if(nr>=0&&nr<rows && nc>=0 && nc<cols && grid[nr][nc]==1){
                grid[nr][nc]=2;
                queue.add(new int[] {nr,nc});
                freshCount--;
               
            }
        }
        }
        
            minutes++;
        }
    return freshCount==0? minutes :-1;
    

    }
}
