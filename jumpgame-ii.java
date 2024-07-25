class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int l=0,r=0,jump=0,farthest=0;
        while(r<n-1){
            for(int j=l;j<=r;j++){
                farthest=Math.max(j+nums[j],farthest);

            }
            l=r+1;
            r=farthest;
            jump=jump+1;

        }
        return jump;
    }
}