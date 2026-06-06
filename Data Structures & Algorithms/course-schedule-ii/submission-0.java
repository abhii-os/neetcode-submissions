class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        int[] count = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] pair:prerequisites){
            int course = pair[0];
            int pre = pair[1];
            adj[pre].add(course);
            count[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(count[i]==0){
                queue.add(i);
            }
        }
        int[] result = new int[numCourses];
        int counts=0;

        while(!queue.isEmpty()){
            int current = queue.poll();
            result[counts++]=current;

            for(int neighbor:adj[current]){
                count[neighbor]--;

                if(count[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }

    return (counts==numCourses)?result:new int[0];
    }
}
