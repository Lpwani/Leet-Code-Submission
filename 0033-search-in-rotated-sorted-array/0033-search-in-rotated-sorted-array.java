class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        int idx = -1;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(target == nums[mid]){
                idx = mid;
                break;
            }
            
            // left half is sorted
            if(nums[mid] >= nums[low]){

                if(target >= nums[low] && target <= nums[mid]){
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }

            // if right half is sorted
            else{
                if(target >= nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }

        }

        return idx;
    }
}