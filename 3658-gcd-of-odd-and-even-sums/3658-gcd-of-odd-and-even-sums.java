class Solution {

    // Euclidean Theorem 
    // GCD(int a, int b) = GCD(int b, int a % b)

    // using recursive apprach
    public int gcd(int a, int b){
        
        if(b == 0){
            return a;
        }

        return gcd(b, a%b);
    }

    public int gcdOfOddEvenSums(int n) {

        int sumOdd = 1;
        int sumEven = 2;

        int currOdd = 1;
        int currEven = 2;

        for(int i = 2; i <= n; i++){
            currOdd += 2;
            currEven += 2;

            sumOdd += currOdd;
            sumEven += currEven;
        }

        System.out.println(sumOdd);
        System.out.println(sumEven);

        int ans = gcd(sumOdd, sumEven);

        return ans;
    }
}