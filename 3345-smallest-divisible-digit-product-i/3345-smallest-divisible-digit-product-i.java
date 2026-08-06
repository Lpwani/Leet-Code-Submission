class Solution {

    public int numProduct(int n){
        int temp = n;
        int prod = 1;
        while(temp != 0){
            int curr = temp%10;
            temp = temp/10;
            prod *= curr;
        }

        return prod;
    }

    public int smallestNumber(int n, int t) {
        int temp = n;
        int prod = 1;

        while(numProduct(temp)%t != 0){
            temp++;
        }

        return temp;
    }
}