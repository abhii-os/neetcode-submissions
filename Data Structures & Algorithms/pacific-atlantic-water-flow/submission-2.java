class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length==0){
            return new ArrayList<>();
        }
       boolean[][] pacific = new boolean[heights.length][heights[0].length];
       boolean[][] atlantic = new boolean[heights.length][heights[0].length];   

       for(int i=0;i<heights.length;i++){
        dfs(i,0,pacific,-1,-1,heights);
        dfs(i,heights[0].length-1,atlantic,-1,-1,heights);
       }
        for(int j=0;j<heights[0].length;j++){
            dfs(0,j,pacific,-1,-1,heights);
            dfs(heights.length-1,j,atlantic,-1,-1,heights);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    list.add(List.of(i, j));
                }
            }
        }
        return list;
       }
    private void dfs(int i, int j, boolean[][] arr, int oi, int oj, int[][] heights){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j] ||
        (oi>=0 && oj>=0 && heights[oi][oj]>heights[i][j])) 
        {return;}

        arr[i][j] = true;

        dfs(i+1,j,arr,i,j,heights);
        dfs(i,j+1,arr,i,j,heights);
        dfs(i-1,j,arr,i,j,heights);
        dfs(i,j-1,arr,i,j,heights);
    }
}
