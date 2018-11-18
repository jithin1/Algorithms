 /* LeetCode : 787. Cheapest Flights Within K Stops
   There are n cities connected by m flights. Each fight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price
from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
  */
  
    // Use dijkstra

  class GraphNode{

      int dest;
      int weight;
      
      GraphNode(int dest,int weight){
          this.dest = dest;
          this.weight = weight;
      }
  }

        class Solution {
    
       HashMap<Integer, ArrayList<GraphNode>> graph = new HashMap();
        int dist[];
       int temp_dist;
       int max_stops;
       int max_prune = Integer.MAX_VALUE;
            
     @SuppressWarnings("unchecked")
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        
        dist = new int[n];
        
        this.max_stops = K;
        
              
         for(int i=0; i<flights.length;i++)
           addEdge(flights[i][0],flights[i][1],flights[i][2]);
        
           for(int i=0; i<n; i++)
               dist[i] = Integer.MAX_VALUE;
        
                    dist[src] =0;
            if(!graph.containsKey(src)) // if there are no edges from this node, then the algorithm ends here
                return -1;
        
           DFS(src,dst,0);
        
         if(dist[dst] != Integer.MAX_VALUE)
             return dist[dst];
        
        else
            return -1;
           
    }
    
        public void DFS(int u,int v,int stop){
            
            if(max_stops < stop || u==v){
                return;
            }

                ArrayList<GraphNode> temp = graph.get(u); 
            
                 if(temp == null)  // to determine leaf node
                      return;
            
            for(GraphNode g : temp){
                  int n = g.dest;
                  int weight = g.weight;
                   
                  if(dist[n] > dist[u]+weight && dist[u]+weight < max_prune){  // to limit the search                 
                     dist[n] = dist[u]+weight;
                    DFS(n,v,stop+1);
                      
                    if(n != v)
                    dist[n] = Integer.MAX_VALUE;  // to preserve the value of the destination node
                      
                      if(dist[v] < max_prune)   // to set the maximum pruning limit
                       max_prune = dist[v];
                  }   
                
            }
        }
    
       public void addEdge(int src,int dest,int weight){
           
                GraphNode g= new GraphNode(dest,weight);
           
            if(!graph.containsKey(src)){
                ArrayList<GraphNode>temp = new ArrayList();
                temp.add(g);
                graph.put(src,temp);
            }
           
             else{
                 ArrayList<GraphNode> temp = graph.get(src);
                 temp.add(g);
                 graph.put(src,temp);
             }
              
       }
}
