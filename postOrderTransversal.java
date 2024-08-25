class Solution {
    public List<Integer> res=new ArrayList<>();
    public void recursion(TreeNode root){
        if(root==null){
            return;
        }
        recursion(root.left);
        recursion(root.right);
        res.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        recursion(root);
        return res;
    }
}