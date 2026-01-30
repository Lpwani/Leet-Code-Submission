class Solution {

    public String lexSmallestAfterDeletion(String s) {
        
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int char_occ[] = new int[26];

        for(int i = 0; i < n; i++){
            char_occ[s.charAt(i)-'a']++;
        }

        for(int i = 0; i < s.length(); i++){

            if(st.isEmpty() || s.charAt(i) >= st.peek()){
                st.push(s.charAt(i));
            }
            else{
                while(!st.isEmpty() && s.charAt(i) < st.peek() && char_occ[st.peek()-'a'] >= 2){
                    char_occ[st.peek() -'a']--;
                    st.pop();
                }
                st.push(s.charAt(i));
            }

        }

        int stk_size = st.size();
        // FIX 1: Use StringBuilder for O(N) construction
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        // Stack pops in reverse order, so we reverse the builder
        sb.reverse();

        // FIX 2: Use deleteCharAt for O(1) removal (replaces pop_back)
        int len = sb.length();
        while(len >= 2 && char_occ[sb.charAt(len-1) - 'a'] > 1){
            char_occ[sb.charAt(len-1) - 'a']--;
            sb.deleteCharAt(len - 1); // Much faster than substring
            len--;
        }

        return sb.toString();
    }

}
