class Solution {

    public boolean isAng(String A, String B){
        int a[] = new int[26];
        int b[] = new int[26];
        boolean ans = true;

        if(A.length() != B.length()){
            ans = false;
            return ans;
        }
        for(int i = 0; i < A.length(); i++){
            a[A.charAt(i)-'a']++;
        }

        for(int i = 0; i < B.length(); i++){
            b[B.charAt(i)-'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]){
                ans = false;
                return ans;
            }
        }

        return ans;
    }

    public List<String> removeAnagrams(String[] words) {
        
        int n = words.length;
        
        for(int i = n-1; i >= 1; i--){
            if(isAng(words[i], words[i-1])){
                words[i] = "-1";
            }
        }

        List <String> ans = new ArrayList<>();

        int currIdx = 0;
        for(int i = 0; i < n; i++){
            if(!words[i].equals("-1")){
                ans.add(currIdx,words[i]);
                currIdx++;
            }
        }

        return ans;
    }
}