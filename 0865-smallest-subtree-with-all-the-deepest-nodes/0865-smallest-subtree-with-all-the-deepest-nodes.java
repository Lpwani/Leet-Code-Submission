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
    TreeNode ans;
    // public int maxTreeDepth(TreeNode root){
    //     Stack <TreeNode>st = new Stack<TreeNode>();

    //     int depth = Integer.MIN_VALUE;

    //     st.push(root);

    //     while(st.empty() == false){
    //         TreeNode temp = st.pop();
    //         System.out.println(temp.val);
    //         if(temp.right != null){
    //             st.push(temp.right);
    //             System.out.println(temp.right);
    //         }                
    //         if(temp.left != null){
    //             st.push(temp.left);
    //             System.out.println(temp.left);
    //         }

    //         depth = Math.max(depth, st.size());
    //     }

    //     return depth;
    // }

    public int depth(TreeNode root, int curDepth, int maxDepth){
        if(root == null){
            return curDepth;
        }
        int leftDepth = curDepth,rightDepth = curDepth;
        if(root.left != null){
            // curDepth++;
            if(curDepth+1 > maxDepth) maxDepth = curDepth+1;
            leftDepth = depth(root.left, curDepth+1, maxDepth);
        }
        if(root.right != null){
            // curDepth++;
            if(curDepth+1 > maxDepth) maxDepth = curDepth+1;
            rightDepth = depth(root.right, curDepth+1,maxDepth);
        }

        if(leftDepth >= rightDepth) return leftDepth;
        else return rightDepth;
    }


    public boolean subtreeRoot(TreeNode root, int depth, int val){
        if(root == null) return false;

        if(depth == val){
            ans = root;
            return true;
        }
        
        boolean left = false, right = false;
        left = subtreeRoot(root.left,depth,val+1);
        right = subtreeRoot(root.right,depth,val+1);


        if(left && right){
            ans = root;
            return true;
        }
        else if(left || right){
            return true;
        }else{
            return false;
        }

        
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int depth = depth(root,0,0);
        System.out.println(depth);
        subtreeRoot(root,depth,0);
        // System.out.println(subtreeRoot(root,depth,0));
        return ans;
    }
}