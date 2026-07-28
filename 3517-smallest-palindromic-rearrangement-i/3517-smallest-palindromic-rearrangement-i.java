class Solution {
    public String smallestPalindrome(String s) {

        // Optimistic 1-pass approach
        // Time Complexity :- O(N)
        // Space Complexity :- O(N) 
        
        int m = s.length();
        int charFreq[] = new int[26];
        char ans[]  = new char[m];
        
        for(int i = 0; i < m; i++){
            charFreq[s.charAt(i) - 'a']++;
        }

        int low = 0;
        int high = m-1;
        for(int i = 0; i < 26; i++){
            while(charFreq[i] != 0 && charFreq[i] != 1){
                ans[low] = (char)('a'+i);
                ans[high] = (char)('a'+i);
                low++;
                high--;
                charFreq[i] = charFreq[i] - 2; 
            }

            if(charFreq[i] == 1){
                ans[(m-1)/2] = (char)('a'+i);
                charFreq[i]--;
            }
        }

        return new String(ans);
    }
}