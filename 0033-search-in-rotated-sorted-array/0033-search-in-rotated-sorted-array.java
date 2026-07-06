class Solution {
    public int search(int[] nums, int target) {
        
        int currElm = nums[0];
        boolean posneg = false;
        int srtIdx = 0;
        int n = nums.length;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] >= nums[i-1]) continue;
            else{
                srtIdx = i;
                break;
            }
        }
        
        int ans = -1;
        for(int i = srtIdx; i < srtIdx + n; i++){
            if(nums[i%n] == target) ans = i % n;
        }
        
        return ans;
        
        
        
        
        
        
        
        
    
        
        
        
        
        // int n = nums.length;
        // int low = 0;
        // int high = n - 1;

        // int idx = -1;

        // while(low <= high){
        //     int mid = low + (high - low)/2;

        //     if(target == nums[mid]){
        //         idx = mid;
        //         break;
        //     }
            
        //     // left half is sorted
        //     if(nums[mid] >= nums[low]){

        //         if(target >= nums[low] && target <= nums[mid]){
        //             high = mid - 1;
        //         }
        //         else {
        //             low = mid + 1;
        //         }
        //     }

        //     // if right half is sorted
        //     else{
        //         if(target >= nums[mid] && target <= nums[high]){
        //             low = mid + 1;
        //         }
        //         else{
        //             high = mid - 1;
        //         }
        //     }

        // }

        // return idx;
    }
}