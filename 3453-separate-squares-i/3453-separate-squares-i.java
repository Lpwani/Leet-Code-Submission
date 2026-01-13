class Solution {

    public double area_below(int[][] squares, double mid){
        
        double below_area = 0.0;

        for(int[] square : squares){
            if(mid >= square[1]+square[2]) below_area += Math.pow(square[2],2);
            else if(square[1] <= mid && (mid < (square[1] + square[2]))){
                double height = mid - square[1];
                below_area += height*square[2];
            }
        }

        return below_area;
    }

    public double separateSquares(int[][] squares) {
        
        double minY = Double.MAX_VALUE;
        double maxY = 0.0;
        double total_area = 0.0;

        for(int square[] : squares){

            double len = (double)square[2];
            minY = Math.min(minY, square[1]);
            maxY = Math.max(maxY, square[1] + square[2]);
            total_area += len*len;
        }

        double half_area = total_area/2;

        double low = minY;
        double high = maxY;

        double mid = 0.0;

        for(int i = 0; i <= 80; i++){
            mid = (low + high)/2.0;

            // we must treat equality as move left since we want minimum value
            // if(area_below(squares, mid) == half_area){
            //     // System.out.println(area_below(squares, mid)+ " "+ half_area);
            //     return mid;
            // }
            if(area_below(squares,mid) >= half_area){
                high = mid;
            }
            else{
                low = mid;
            }
        }

        return low;
    }
}