class Solution {
    public int passThePillow(int n, int time) {
        int count=1;
        int increase=1;
        int strt=0;
        while(strt<time){
            count+=increase;
            if(count==n || count==1){
                increase=-increase;
            }
            strt++;

        }
        return count;
    }
}