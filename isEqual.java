class Solution {
    public boolean isEqual( int freq[]) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) return false;
        int freq[] = new int[26];
        for (int i = 0; i < n1; i++) {
            freq[s1.charAt(i)-'a']++;
        }
        int i = 0, j = 0;
        for (j = 0; j < n1; j++) {
            freq[s2.charAt(j)-'a']--;
        }
        if (isEqual(freq)) return true;
        while (j < n2) {
            freq[s2.charAt(i)-'a']++;
            i++;
            freq[s2.charAt(j)-'a']--;
            j++;
            if (isEqual(freq)) return true;
        }
        return false;
    }
}