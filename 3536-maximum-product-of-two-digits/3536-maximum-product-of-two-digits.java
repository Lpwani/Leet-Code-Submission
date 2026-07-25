class Solution {
    public int maxProduct(int n) {
        
        int temp = n;
        int currOp = 0;
        int currMaxDig = 0;
        int ans = Integer.MIN_VALUE;

        while(temp > 0){
            int dig = temp%10;
            if(currOp == 0) {
                currOp++;
                currMaxDig = dig;
            }    
            else{
                ans = Math.max(currMaxDig*dig, ans);
                currMaxDig = Math.max(currMaxDig, dig);        
            }

            temp = temp/10;
        }

        return ans;
    }
}
