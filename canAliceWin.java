class Solution {
    public boolean canAliceWin(int[] nums) {
        int n = nums.length;
        int sdsum=0,ddsum=0;
        for(int i=0;i<n;i++){
            if(nums[i]<10){
                sdsum+=nums[i];
            }
            else{
                ddsum+=nums[i];
            }
        }
        if(sdsum==ddsum){
            return false;
        }
        return true;
    }
}