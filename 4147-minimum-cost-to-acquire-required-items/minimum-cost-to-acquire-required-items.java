class Solution {
    public long minimumCost(int c1, int c2, int cb, int n1, int n2) {
        long ans  = 0 ;
        int pairs = Math.min(n1,n2);
        ans += pairs * Math.min((long)c1+c2 ,(long) cb);
        n1 -= pairs; 
        n2 -= pairs;
        if(n1 > 0){
            ans += 1L * n1 * Math.min((long)c1,(long)cb);
        } 
        if(n2 > 0){
            ans += 1L * n2 * Math.min((long)c2,(long)cb);
        } 
        return ans;
    }
}