class Solution {
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj,
    boolean vls[],int node,ArrayList<Integer> ls
    
    ){
        vls[node]=true;
        ls.add(node);
        for (Integer it:adj.get(node)){
            if(vls[it]==false){
                dfs(adj,vls,it,ls);
            }
        }
        
        
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean vls[]=new boolean[V+1];
        vls[0]=true;
        ArrayList<Integer> ls=new ArrayList<>();
        dfs(adj,vls,0,ls);
        return ls;
        
        
        
    }
    
}