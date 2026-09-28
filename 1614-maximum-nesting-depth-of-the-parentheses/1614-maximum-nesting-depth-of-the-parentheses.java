class Solution {

    // Time complexity : O(N)
    public int maxDepth(String s) {
        int ans = 0;
        int crAns = 0;
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '('){
                ans = Math.max(ans,++crAns);
            }
            else if(curr == ')') crAns--;

        }

        return ans;
    }
}