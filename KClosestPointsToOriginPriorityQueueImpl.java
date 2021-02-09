//problem reduces to finding k smallest numbers
//we can use PriorityQueue
class KClosestPointsToOriginPriorityQueueImpl {
    public int[][] kClosest(int[][] points, int K) {
        
        if(K>points.length) return points;
        
        PriorityQueue<int[]> pq = new PriorityQueue(new EucliedeanDistanceComparator());
        for(int[] point : points){
            pq.add(point);
        }
        
        int[][] result = new int[K][2];
        int i = 0;
        while(K-->0){
            result[i++] = pq.poll();
        }
        
        return result;
    }
    
    private int squaredEucliedeanDistanceFromZero(int[] point){
        return (point[0]*point[0])+(point[1]*point[1]);
    }
    
    private class EucliedeanDistanceComparator implements Comparator<int[]>{
        public int compare(int[] p1, int[] p2){
            return squaredEucliedeanDistanceFromZero(p1)-squaredEucliedeanDistanceFromZero(p2);
        }
    }
}
