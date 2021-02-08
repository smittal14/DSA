/*
*https://leetcode.com/problems/min-cost-to-connect-all-points/
*following problem wants us to find MST in a graph.
*vertices are the points in 2D plane.
*edges is the manhattan distance.
*based on our problem, we have nC2 edges in graph (n is number of vertices)
*
*Algorithm:
*we can use prim's algo or kruskal's algo to find the MST
*if we store all these edges to sort for kruskal then it will require O(n2) space 
*hence it is better to use prim's algo which will require O(n) space
*
*Prims's Algo :
*make 2 sets of vertices - visited, not-visited
*assign infinite as the key of all vertices
*assign 0 as the key of source (1st) vertice
*repeat following until all vertices visited
*add min key vertice to visited set
*update the key of its adjacent vertices = Math.min(currentKeyOfDestination,edgeFromMinVToDestination)
*update the parent of Destination in case we are changing the key for a vertex
*weight of the spanning tree will be equal to sum of all edges included in ST
*
*/
class PrimsAlgorithm {
    
    public int minCostConnectPoints(int[][] points) {
        return primsAlgoMST(points);
    }
    
    /*
    *Todo : Priority Queue implementation of Prim's algo for ElogV time complexity
    */
    private int primsAlgoMST(int[][] points){
        boolean[] visited = new boolean[points.length];
        
        int[] keys = new int[points.length];
        Arrays.fill(keys,Integer.MAX_VALUE);
        keys[0] = 0;

        int[] parents = new int[points.length];
        Arrays.fill(parents,-1);//Not needed in this question
        
        for(int i=0;i<points.length;i++){
            int minIndex = findMinKeyIndex(keys,visited);
            visited[minIndex] = true;

            for(int j=0;j<points.length;j++){
                if(visited[j]==false){
                    int edgeLength = findDistanceBetween2Points(points[minIndex],points[j]);
                    if(keys[j]>edgeLength){
                        parents[j] = minIndex;
                        keys[j] = edgeLength;
                    }                    
                }

            }
        }
        
        int minCost = 0;
        for(int i=1;i<points.length;i++){
            minCost = minCost + findDistanceBetween2Points(points[i],points[parents[i]]);
        }
        
        return minCost;    
    }
    
    private int findDistanceBetween2Points(int[] point1, int[] point2){
        return Math.abs(point1[0]-point2[0])+Math.abs(point1[1]-point2[1]);
    }
    
    private int findMinKeyIndex(int[] keys, boolean[] visited){
        int minIndex = -1;//default value, will not be returned in this question
        int minKey = Integer.MAX_VALUE;
        for(int i=0;i<keys.length;i++){
            if(keys[i]<minKey && visited[i]==false){
                minIndex = i;
                minKey = keys[i];
            }
        }
        return minIndex;    
    }
}
