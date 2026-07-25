class Solution {
    public int maxProduct(int n) {
        
        // Optimized and structured solution
        // time Complexity : O(number of digits)
        // Space Complexity : O(1)

        int temp = n;

        int currMaxDig = temp%10;
        temp = temp/10;
        int ans = Integer.MIN_VALUE;

        while(temp > 0){
            int dig = temp%10;
            ans = Math.max(currMaxDig*dig, ans);
            currMaxDig = Math.max(currMaxDig, dig);
            temp = temp/10;
        }

        return ans;
    }
}
