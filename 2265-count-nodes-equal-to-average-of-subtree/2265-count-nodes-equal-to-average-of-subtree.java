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

    int ans = 0;

    public int numNodesSubtree(TreeNode root){
        if(root == null) return 0;

        int left;
        if(root.left != null){
            left = 1 + numNodesSubtree(root.left);
        }
        else{
            left = numNodesSubtree(root.left);
        }
        
        int right;
        if(root.right != null){
            right = 1 + numNodesSubtree(root.right);
        }
        else{
            right = numNodesSubtree(root.right);
        }

        return 1 + left + right;
    }

    public int nodesAvg(TreeNode root){
        
        if(root == null) return 0;

        int left;

        if(root.left != null){
            left = root.left.val + nodesAvg(root.left);
        }
        else left = nodesAvg(root.left);

        int right;
        if(root.right != null){
            right = root.right.val + nodesAvg(root.right);
        }
        else{
            right = nodesAvg(root.right);
        }

        int sum = root.val + left + right;

        int cnt = numNodesSubtree(root);

        if(sum/cnt == root.val) ans++;
        
        return sum;

    }

    public int averageOfSubtree(TreeNode root) {
        
        // Time Complexity : O(N^2)
        // Space Complexity : O(H)

        nodesAvg(root);

        return ans;
    }
}