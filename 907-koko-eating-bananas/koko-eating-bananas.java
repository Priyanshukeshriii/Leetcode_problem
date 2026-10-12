class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1 ;
        int r = 1000000000;
        while(l < r){
            int m  = l + (r-l)/2;
            long currh = 0;
            for(int b : piles){
                currh += (b + m - 1) / m;
            }
            if(currh > h){
                l = m+1;
            }else{
                r = m;
            }
        }
        return l;
        
    }
}