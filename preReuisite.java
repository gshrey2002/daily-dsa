class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
            
        }
        int m=prerequisites.length;
        
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        int inDegree[]=new int[N];
        for(int i=0;i<N;i++){
            for(int it:adj.get(i)){
                inDegree[it]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<N;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        List<Integer> topo=new ArrayList<Integer>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            
            topo.add(node);
            
            for(int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0) q.add(it);
            }
        }
        
        if(topo.size()==N ) return true;
        return false;
    }
    
}