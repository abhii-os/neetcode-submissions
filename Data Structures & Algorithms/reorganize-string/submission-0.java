class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++ ;
        }

        PriorityQueue<Character>maxHeap = new PriorityQueue<>(
            (a,b)->Integer.compare(count[b-'a'],count[a-'a']));
        
        for(int i=0; i<26;i++){
            if(count[i]>0){
                if(count[i]>(s.length()+1)/2){
                    return "";
                }
            maxHeap.add((char)('a'+i));
            }
        }
        StringBuilder sb = new StringBuilder();

        while(maxHeap.size()>=2){
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            sb.append(first);
            sb.append(second);

            count[first - 'a']--;
            count[second - 'a']--;

            if(count[first-'a']>0){
                maxHeap.add(first);
            }
            if(count[second - 'a']>0){
                maxHeap.add(second);
            }
        }
        if(!maxHeap.isEmpty()){
            char last = maxHeap.poll();
            sb.append(last);
        }
    return sb.toString();
    }
}