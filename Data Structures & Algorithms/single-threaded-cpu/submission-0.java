class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] sortedTasks = new int[n][3];
        for(int i=0; i<n;i++){
        sortedTasks[i][0] = tasks[i][0];
        sortedTasks[i][1]=tasks[i][1];
        sortedTasks[i][2]=i;
        }
        Arrays.sort(sortedTasks,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->
        {
            if(a[1]!=b[1]){
                return Integer.compare(a[1],b[1]);
            }
            else{
                return Integer.compare(a[2],b[2]);
            }
        });
        int [] result = new int[n];
        int currentTime = 0;
        int resultIdx = 0;
        int tskIdx = 0;

        while(!minHeap.isEmpty() || tskIdx<n){
            if(minHeap.isEmpty() && currentTime<sortedTasks[tskIdx][0]){
                currentTime = sortedTasks[tskIdx][0];
            }

            while(tskIdx<n && sortedTasks[tskIdx][0]<=currentTime){
                minHeap.add(sortedTasks[tskIdx]);
                tskIdx++;
            }
            int[]currentTasks = minHeap.poll();
            result[resultIdx++] = currentTasks[2]; 
            currentTime += currentTasks[1];
        }
        return result;    
    }
}