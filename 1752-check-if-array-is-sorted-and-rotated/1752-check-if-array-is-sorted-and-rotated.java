class Solution {
    public boolean check(int[] nums) {
        int noSignChange = 0;
        for(int i = 0;i <nums.length; i++){
            if(i == nums.length - 1){
                if(nums[i] > nums[0]) noSignChange++;
            }
            else{
                if(nums[i] > nums[i+1]) noSignChange++;
            }
        }
        if(noSignChange <= 1) return true;
        else return false;
    }
}