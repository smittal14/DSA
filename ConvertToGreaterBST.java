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
    int prev = 0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeNode root) {
        if (root == null) return;
        convertBST(root.right);
        root.val = prev + root.val;
        prev  = root.val;
        convertBST(root.left);
    }
}
