class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] req : prerequisites){
            int course = req[0];
            int require = req[1];
            adj.get(require).add(course);
        }
        int[] state = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(state[i]==0){
                if(hasCycle(i,adj,state)) return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int curr, List<List<Integer>> adj, int[] state){
        state[curr] = 1;
        for(int neighbor:adj.get(curr)){
            if(state[neighbor]==1) return true;
            if(state[neighbor]==0){
                if(hasCycle(neighbor,adj,state)) return true;
            }
            
        }
        state[curr] = 2;
        return false;
    }
}
