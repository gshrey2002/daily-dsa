class Solution {
    public long gridGame(int[][] grid) {
        int m=grid[0].length;
        if (m < 2) return 0;
        
        long totalTopsum=0;
        // for(int i=0;i<m;i++){
        //     totalTopsum+=grid[0][i];
        // }
         for (int val : grid[0]) {
            totalTopsum += val;
        }

        long bottomSum=0;
        long minSum=Long.MAX_VALUE;
        for(int pp=0;pp<m;++pp){
            totalTopsum-=grid[0][pp];
            minSum=Math.min(minSum,Math.max(totalTopsum,bottomSum));
            bottomSum+=grid[1][pp];

        }

        return minSum;
    }
}