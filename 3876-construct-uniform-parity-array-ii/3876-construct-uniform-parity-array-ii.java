class Solution {
    public boolean uniformArray(int[] nums1) {
        
        Arrays.sort(nums1);

        int n = nums1.length;
        int smallOdd = Integer.MAX_VALUE;
        int smallEven = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(smallEven != Integer.MAX_VALUE && smallOdd != Integer.MAX_VALUE){
                break;
            }
            if(nums1[i] % 2 == 0){
                smallEven = Math.min(smallEven, nums1[i]);
            }
            if(nums1[i] % 2 == 1){
                smallOdd = Math.min(smallOdd, nums1[i]);
            }
        }

        if(smallEven == Integer.MAX_VALUE || smallOdd == Integer.MAX_VALUE) return true;
        if(smallEven < smallOdd) return false;
        else return true;
    }
}