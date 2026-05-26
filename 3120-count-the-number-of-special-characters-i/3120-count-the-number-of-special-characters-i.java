class Solution {
    public int numberOfSpecialChars(String word) {
 
        HashSet<Character> ch_set = new HashSet<>();
        int n = word.length();
        int ans = 0;

        int csd_ch[] = new int[26];
        for(int i = 0; i < 26; i++){
            csd_ch[i] = 0;
        }

        for(int i = 0; i < n; i++){
            
            char ch = word.charAt(i);
            ch_set.add(ch);

            if((int)ch >= 97 && (int)ch <= 122){
                if(csd_ch[(int)ch - 97] == 0 && ch_set.contains((char)((int)ch - 32))){
                    csd_ch[(int)ch - 97] = 1;
                    ans++;
                }
            }
            else if((int)ch >= 65 && (int)ch <= 90){
                if(csd_ch[(int)ch - 65] == 0 && ch_set.contains((char)((int)ch +32))){
                    csd_ch[(int)ch - 65] = 1;
                    ans++;
                }
            }
            
        }
        
        return ans;
    }
}