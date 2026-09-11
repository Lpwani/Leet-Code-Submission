class Solution {
    public int totalNumbers(int[] digits) {

        // space complexity : O(1)
        // time complexity : O(N)

        int n = digits.length;
        int sum = n;
        HashMap<Integer, Integer> hm = new HashMap<>();

        int ans = 0;

        for(int i = 0; i < n; i++){
            hm.put(digits[i], hm.getOrDefault(digits[i],0)+1);
        }

        HashMap<Integer,Integer> temp = new HashMap();

        for(int i = 100; i <= 999; i = i+2){
            temp = new HashMap<>(hm);
            Integer curr = i;

            String currStr = Integer.toString(curr);
            boolean isPoss = true;

            for(int j = 0; j < 3; j++){
                int currElm = currStr.charAt(j)-'0';

                if(temp.getOrDefault(currElm,0) > 0){
                    temp.put(currElm, temp.get(currElm)-1);
                }
                else{
                    isPoss = false;
                    break;
                }
            }

            if(isPoss == true){
                ans++;
            }
        }

        return ans;
    }
}