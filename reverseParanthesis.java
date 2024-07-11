class Solution {
    int index = 0;
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        
        while(index < s.length()) {
           char ch = s.charAt(index);
           if(ch == '(') {
               index++;
               String st = reverseParentheses(s);
               String reversed = new StringBuilder(st).reverse().toString();
               sb.append(reversed);
           } else if( ch == ')') {
               index++;
               break;
           } else {
               sb.append(ch);
               index++;
           }
        }
        
        return sb.toString();
    }
}