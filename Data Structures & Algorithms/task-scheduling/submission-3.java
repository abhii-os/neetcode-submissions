class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char t:tasks){
            freq[t-'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int count:freq){
            if(count>0){
            heap.add(count);
        }
        }
        int totalTime = 0;
        while(!heap.isEmpty()){
            List<Integer>temp = new ArrayList<>();
            int cycle = n+1;

            while(cycle>0 && !heap.isEmpty()){
                int currFreq = heap.poll();

                if(currFreq-1>0){
                    temp.add(currFreq-1);
                }
                totalTime++;
                cycle--;
            }
            for(int remainingFreq:temp){
                heap.add(remainingFreq);
            }
        if(!heap.isEmpty()){
            totalTime += cycle;
        }
        }
        return totalTime;
    }

}
