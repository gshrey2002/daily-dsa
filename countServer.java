class Solution {
    public int countServers(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int totalServer=0;
        int rows[]=new int[m];
        int col[]=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    rows[i]++;
                    col[j]++;
                    totalServer++;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && rows[i]==1 && col[j]==1){
                    totalServer-=1;
                }

            }
            }
            return totalServer;
        
    }
}