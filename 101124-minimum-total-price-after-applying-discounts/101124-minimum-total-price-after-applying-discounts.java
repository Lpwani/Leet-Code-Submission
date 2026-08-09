class Solution {
    public double minPrice(int[] prices, int[] discounts) {

        int n = prices.length;
        int m = discounts.length;
        
        double ans = 0;

        Integer[] price = Arrays.stream(prices)
                    .boxed()
                    .toArray(Integer[]::new);

        Integer[] discount = Arrays.stream(discounts)
                    .boxed()
                    .toArray(Integer[]::new);

        Arrays.sort(price, Collections.reverseOrder());
        Arrays.sort(discount, Collections.reverseOrder());

        int pIdx = 0, dIdx = 0;

        while(pIdx < n && dIdx < m){
            ans += (((double)price[pIdx]*(100-discount[dIdx]))/100);
            pIdx++;
            dIdx++;
        }

        while(pIdx < n){
            ans += price[pIdx];
            pIdx++;
        }

        return ans;
    }
}