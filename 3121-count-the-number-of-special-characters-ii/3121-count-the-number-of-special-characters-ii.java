class Solution {
    public int numberOfSpecialChars(String word) {
        
        int upp[] = new int[26];
        int low[] = new int[26];

        for(int i = 0; i < 26; i++){
            upp[i] = -1;
            low[i] = -1;
        }

        int n = word.length();

        int ans = 0;

        // System.out.println((int)'a'+" "+(int)'z'+" "+(int)'A'+" "+(int)'Z');
        // 97 122 65 90

        for(int i = 0; i < n; i++){
            int ch = (int)word.charAt(i);

            if(ch >= 65 && ch <= 90){
                if(upp[ch-65] == -1){
                    upp[ch-65] = i;
                }
            }
            else if(ch >= 97 && ch <= 122){
                low[ch-97] = i;
            }
        }

        for(int i = 0; i < 26; i++){
            if(low[i] != -1 && upp[i] != -1 && low[i] < upp[i]){
                ans++;
            }
        }
        return ans;
    }
}