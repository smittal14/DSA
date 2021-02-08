class LRUCacheTimeStampImpl {
    
    int capacity;
    HashMap<Integer,Integer> keyValueMap = new HashMap<>();
    HashMap<Integer,Integer> keyTimeMap = new HashMap<>();
    int holding = 0;
    int timeStamp = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!keyValueMap.containsKey(key)) return -1;
        timeStamp++;
        keyTimeMap.put(key,timeStamp);
        return keyValueMap.get(key);
    }
    
    public void put(int key, int value) {
        if(!keyValueMap.containsKey(key)){
            if(holding==capacity){
                int minKey = findKeyWithMinValue(keyTimeMap);
                keyTimeMap.remove(minKey);
                keyValueMap.remove(minKey);
            }
            else{
                holding++;
            }
        }

        timeStamp++;
        keyValueMap.put(key,value);
        keyTimeMap.put(key,timeStamp);
                
        return;
    }
	
	private int findKeyWithMinValue(HashMap<Integer,Integer> keyValueMap){
	    
	    int minValue = Integer.MAX_VALUE;
	    int minValueKey = -1;
	    
	    for(Map.Entry<Integer,Integer> keyValuePair : keyValueMap.entrySet()){
	        if(keyValuePair.getValue()<minValue){
	            minValue = keyValuePair.getValue();
	            minValueKey = keyValuePair.getKey();
	        }
	    }
	    
	    return minValueKey;
	}

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
