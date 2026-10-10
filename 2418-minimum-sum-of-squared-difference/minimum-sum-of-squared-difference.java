
class Solution {
    public long minSumSquareDiff(int[] n1, int[] n2, int k1, int k2) {
        long sum = 0;
        for (int i = 0 ; i < n1.length ; i++){
            n1[i] = Math.abs(n1[i] - n2[i]);
            sum+=n1[i];
        }
        if(sum <= k1 + k2) return 0;
        long l = 0, r = 100000;
        long ans = 0;
        long extra_ops = 0;
        while(l < r){
            long m  = (l+r)/2;
            long ops = 0;
            for(int n : n1){
                ops += Math.max(0L , n-m);
            }
            if(ops > k1+k2){
                l = m+1;
            }else{
                r = m;
                extra_ops = k1+k2-ops;
            }
        } 
        for(int n : n1){
            long val = n < l ? n : Math.max(0L , l-(--extra_ops >=0 ? 1:0));
            ans += val*val;
        }
        
        return ans;
    }
}
