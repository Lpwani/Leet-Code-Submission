class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        boolean ans = true;

        int n = s.length();
        for(int i = 0; i < n-1; i++){
            int a = (int)s.charAt(i);
            int b = (int)s.charAt(i+1);

            int diff = Math.abs(b-a);

            if(diff > 2){
                ans = false;
                break;
            }
        }

        return ans;
    }
}