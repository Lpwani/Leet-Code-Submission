class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        if(n <= 2) return n;
        else{
            int msbNpos = 0;
            while(n != 1){
                n = n/2;
                msbNpos++;
            }

            return (int)Math.pow(2,msbNpos+1);
        } 
    }
}