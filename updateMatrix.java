class Pair{
    int first;
    int second;
    int third;

    Pair(int _first,int _second,int _third){
        this.first=_first;
        this.second=_second;
        this.third=_third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int vis[][]=new int[n][m];
        int dist[][]=new int[n][m];
        Queue<Pair> q=new LinkedList<Pair>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=0;

                }else{
                    vis[i][j]=1;
                }     
            }
        }

int delRow[]={-1,0,+1,0};
int delCol[]={0,+1,0,-1};
while(!q.isEmpty()){
    int row=q.peek().first;
    int col=q.peek().second;
    int step=q.peek().third;
    q.remove();
    dist[row][col]=step;
    for(int i=0;i<4;i++){
        int nrow=delRow[i]+row;
        int ncol=delCol[i]+col;

        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==1){
            vis[nrow][ncol]=0;
            q.add(new Pair(nrow,ncol,step+1));

        }


    }
}
        return dist;
    }
}