/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    private int bToD(String s)
    {
        int val = 0;
        int base = 1;  
        int len = s.length(); 
        for (int i = len - 1; i >= 0; i--) 
        { 
            if (s.charAt(i) == '1') 
                val += base; 
            base = base * 2; 
        } 
  
        return val;
    }
    
    private void next(TreeNode root, String s)
    {
        if(root.left == null && root.right == null)
        {
            sum += bToD(s);
            return;
        }
        if(root.left!=null)
            next(root.left, s+String.valueOf(root.left.val));
        if(root.right!=null)
            next(root.right, s+String.valueOf(root.right.val));
    }
    
    int sum;
    
    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        
        if(root == null)
            return sum;
        
        next(root, String.valueOf(root.val));
        
        return sum;
    }
}