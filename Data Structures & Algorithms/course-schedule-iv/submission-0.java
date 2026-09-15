class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] isPre = new boolean[numCourses][numCourses];
        
        for (int[] req : prerequisites) {
            int u = req[0];
            int v = req[1];
            isPre[u][v] = true;
        }

        for(int a=0;a<numCourses;a++){
            for(int b=0;b<numCourses;b++){
                for(int c=0;c<numCourses;c++){
                    if(isPre[a][b]&& isPre[b][c]){
                        isPre[a][c] = true;
                    }
                }
            }
        }
       List<Boolean> result = new ArrayList<>();
       for(int[] q : queries){
        int u = q[0];
        int v = q[1];
        result.add(isPre[u][v]);
       }
       return result;
    }
}