class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int n = 0;
        ListNode temp = head;
        
        // Count the number of nodes in the linked list
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        
        int q = n / k;
        int r = n % k;
        
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            res[i] = curr;
            int partSize = q + (r > 0 ? 1 : 0); // Add an extra node for first r parts
            
            for (int j = 1; j < partSize && curr != null; j++) {
                curr = curr.next;
            }
            
            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null; // Break the link
                curr = next;
            }
            
            if (r > 0) r--;
        }
        
        return res;
    }
}