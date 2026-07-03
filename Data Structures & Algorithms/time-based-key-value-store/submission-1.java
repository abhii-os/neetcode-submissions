class TimeMap {

    private static class DataNode{
        int timestamp;
        String value;

        DataNode(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private HashMap<String, List<DataNode>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());

        map.get(key).add(new DataNode(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<DataNode> history = map.get(key);
        return binarySearch(history,timestamp);
    }

    private String binarySearch(List<DataNode> history, int targetTime){
        int low = 0;
        int high = history.size() - 1;
        String result = "";
        while(low<=high){
            int mid = low + (high-low)/2;
            if(history.get(mid).timestamp <= targetTime){
                result = history.get(mid).value;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;
    }
}
