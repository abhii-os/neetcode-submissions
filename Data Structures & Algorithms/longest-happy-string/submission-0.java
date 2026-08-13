class Solution {
    private static class Pair{
        int count;
        char ch;

        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
       PriorityQueue<Pair> maxHeap = new PriorityQueue<>(((x,y)->(y.count-x.count)));
       if(a>0)maxHeap.offer(new Pair('a',a));
       if(b>0)maxHeap.offer(new Pair('b',b));
       if(c>0)maxHeap.offer(new Pair('c',c));

       StringBuilder sb = new StringBuilder();

       while(!maxHeap.isEmpty()){
        Pair first = maxHeap.poll();
        int len = sb.length();

        if(len>=2&&sb.charAt(len-1)==first.ch && sb.charAt(len-2)==first.ch){
            if(maxHeap.isEmpty()){
                break;
            }
            Pair second = maxHeap.poll();
            sb.append(second.ch);
            second.count--;

            if(second.count>0){
                maxHeap.add(second);
            }
            maxHeap.add(first);
        }
        else{
            sb.append(first.ch);
            first.count--;
            if(first.count>0){
                maxHeap.offer(first);
            }
        }
       }
       return sb.toString();
    }
}