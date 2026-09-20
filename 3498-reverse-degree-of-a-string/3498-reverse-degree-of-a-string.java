class Solution {
    public int reverseDegree(String s) {
        int n = s.length();

        int idx = 1;
        int ans = 0;

        for(int i = 0; i < n; i++){
            int curr = s.charAt(i) - 'a' + 1;

            int currVal = 26 - curr + 1;

            ans += (currVal * idx++);
        }

        return ans;
    }
}