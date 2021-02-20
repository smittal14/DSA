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

/*
Ideation - since its binary tree, think about :
    recursive approach
    base cases
    tree traversal orders
    
Traversal
    this matters a lot since we care for order of our calculation
    think about arranging the numbers in descending order
    how do we traverse in above way?

Ascending order traversal in BST (just for info)
    (traverse left) -> (visit root) -> (traverse right)

Descending order traversal in BST
    (traverse right) -> (visit root) -> (traverse left)
    
During descending order travel
    prev stores sum till previous number
    add prev to current number to assign it the required value
*/

class ConvertToGreaterBST {    
    public TreeNode convertBST(TreeNode root) {
        helper(root,0);
        return root;
    }
    public int helper(TreeNode root, int prev) {
        if (root == null) return prev;
        root.val = root.val + helper(root.right,prev);
        return helper(root.left,root.val);
    }
}
