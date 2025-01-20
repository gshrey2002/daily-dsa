class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Map<Integer,int[]> mp=new HashMap<>();
        int[] rowStore=new int[m];
        int colStore[]=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mp.put(mat[i][j],new int[]{i,j});
            }

        }

        for(int i=0;i<arr.length;i++){
            int coordinate[]=mp.get(arr[i]);
            int x=coordinate[0];
            int y=coordinate[1];

            rowStore[x]++;
            colStore[y]++;
            if(rowStore[x]==n || colStore[y]==m){
                return i;
            }


        }  
        return 0;
        
    }
}