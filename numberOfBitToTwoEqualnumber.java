class Solution {
    public int minChanges(int n, int k) {
        if ( (n & k) != k)
            return -1;
        
        int res = 0;
        
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            res += c - '0';    
        }
        
        for (char c : Integer.toBinaryString(k).toCharArray()) {
            res -= c - '0';    
        }
        
        return res;
    }
}