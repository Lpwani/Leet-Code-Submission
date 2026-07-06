class Solution {

    // Heap Sort implementation

    public void heapify(int nums[], int n, int i){

        int left = i*2 + 1;
        int right = i*2 + 2;
        int largestIdx = i;

        if(left < n && nums[left] > nums[i]) largestIdx = left;
        if(right < n && nums[right] > nums[largestIdx]) largestIdx = right;

        if(largestIdx != i){
            // swap nums[i] and nums[largestIdx]
            int temp = nums[i];
            nums[i] = nums[largestIdx];
            nums[largestIdx] = temp;

            heapify(nums, n, largestIdx);
        }

    }

    public void buildHeap(int nums[]){
        int n = nums.length;

        for(int i = (n-2)/2; i >= 0; i--){
            heapify(nums,n, i);
        }
    } 
    public int[] sortArray(int[] nums) {
        
        int n = nums.length;
        // int ans[] = new int[n];

        // int heapArr[] = buildHeap(nums);
        buildHeap(nums);

        int currPrevIdx = n - 1;
        int corrIdx = 0;

        for(int i = currPrevIdx; i >= 0; i--){
            // swap nums[0] and nums[i]
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums,i, 0);
        }

        return nums;
    }
}