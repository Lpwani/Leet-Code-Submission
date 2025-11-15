class Solution {

    // code for finding GCD of two number
    public int GCD(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }


    public int minOperations(int[] nums) {
        
        int n = nums.length;

        // Case 1: If the nums contains atleast one '1' then the we can make
        // all element one, since GCD of (a,1) will always be 1

        // Generalized formula
        // we can make all element one in n-1 operation.

        int noOnes = 0;
        boolean onePst = false;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                noOnes++;
                onePst = true;
            }
        }

        if(onePst == true) return n-noOnes;
        // Case 2 : If there is no one in the array then we will directly perform the 
        // Gcd of two number continuosly until we get the one. 

        // Note :- while we are performing GCD we have to keep count of the operation
        // so we are making minOp variable to store the minimum oparation for first one from nested loops.

        // Total number of operations will be minOp + (n-1)

        else{
            int minOp = Integer.MAX_VALUE;  // minOp required for getting first one
            boolean onePoss = false;

            for(int i = 0; i < n; i++){
                int temp = nums[i];
                for(int j = i+1; j < n; j++){
                    temp = GCD(temp,nums[j]);
                    if(temp == 1){
                        minOp = Math.min(minOp, j-i);
                        onePoss = true;
                    }
                }
            }

            if(onePoss == false) return -1;
            else return minOp+(n-1);
        }
    }
}