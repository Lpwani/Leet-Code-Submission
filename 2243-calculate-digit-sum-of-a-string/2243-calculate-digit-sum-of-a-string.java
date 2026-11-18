class Solution {
    public String digitSum(String s, int k) {


        // Worst an unmotivated solution of my entire life.....
        // unrevised java concept

        // ArrayList<String> temp = new ArrayList<>();

        int curr = s.length();
        String temp = new String(s);
        String xtemp = "";

        while(curr > k){
            int ptr = 0;
            xtemp = "";
            while(ptr < curr){
                int end = (ptr+k < curr)?ptr+k:curr;
                String currBatch = temp.substring(ptr, end);
                // System.out.println(currBatch+" "+ ptr + " "+ end + " "+curr);
                Integer currVal = 0;
                for(int i = 0; i < currBatch.length(); i++){
                    currVal += (int)currBatch.charAt(i) - (int)'0';
                }
                // System.out.println(currVal+" ");
                xtemp = xtemp +""+currVal.toString();
                System.out.println(xtemp);
                ptr = ptr + k;
            }

            temp = xtemp;

            // curr = (int)Math.ceil(curr/k);
            curr = temp.length();

            // System.out.println(curr +" "+ k);
        }

        return temp;
    }
}