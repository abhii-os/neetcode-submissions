class Twitter {
    private static int timeStamp = 0;
    private static class Tweet{
        int id;
        int time;
        Tweet next;

        Tweet(int id){
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }
    private Map<Integer,Set<Integer>> follows;
    private Map<Integer,Tweet> userTweets;


    public Twitter() {
        follows = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId);
        newTweet.next = userTweets.get(userId);
        userTweets.put(userId, newTweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b)->b.time-a.time);
        
        Set<Integer> followees = follows.getOrDefault(userId, new HashSet<>());
        Set<Integer> authors = new HashSet<>(followees);
        authors.add(userId);

        for(int author:authors){
            Tweet head = userTweets.get(author);
            if(head!=null){
                maxHeap.add(head);
            }
        }

        while(!maxHeap.isEmpty() && feed.size()<10){
            Tweet newest = maxHeap.poll();
            feed.add(newest.id);

            if(newest.next != null){
                maxHeap.add(newest.next);
            }
        }
        return feed;

    }
    
    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k->new HashSet<>()).add
        (followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = follows.get(followerId);
        if(set!=null){
            set.remove(followeeId);
        }
    }
}
