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

    class pair{
        int sum;
        int cnt;

        pair(){
            sum = 0;
            cnt = 0;
        }
        pair(int sum, int cnt){
            this.sum = sum;
            this.cnt = cnt;
        }
    }

    public pair nodesAvg(TreeNode root){
        
        if(root == null) return new pair(0,0);

        pair left = nodesAvg(root.left);
        pair right = nodesAvg(root.right);

        int sum = root.val + left.sum + right.sum;
        int cnt = 1 + left.cnt + right.cnt;

        if(sum/cnt == root.val) ans++;

        return new pair(sum, cnt);

    }

    public int averageOfSubtree(TreeNode root) {
        
        // Time Complexity : O(N)
        // Space Complexity : O(H)

        nodesAvg(root);

        return ans;
    }
}