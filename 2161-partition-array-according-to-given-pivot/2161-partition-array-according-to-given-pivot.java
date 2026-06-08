class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        // Java Naive solution

        int n = nums.length;

        ArrayList <Integer> sml = new ArrayList<>();
        ArrayList <Integer> lrg = new ArrayList<>();

        int pvtCnt = 0;

        int ans[] = new int[n];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < pivot){
                sml.add(nums[i]);
            } 
            else if(nums[i] == pivot){
                pvtCnt++;
            } 
            else lrg.add(nums[i]);
        }

        for(int i = 0; i < sml.size(); i++){
            ans[i] = sml.get(i);
        }
        for(int i = 0; i < pvtCnt; i++){
            ans[sml.size()+i] = pivot;
        }
        for(int i = 0; i < lrg.size(); i++){
            ans[sml.size()+pvtCnt+i] = lrg.get(i);
        }

        return ans;
    }
}