class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend  == divisor) return 1;
        boolean sign = true;
        if(dividend <= 0 && divisor >0) sign = false;
        else if(dividend >= 0 && divisor <0) sign = false;
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        long ans = 0;
        while(n >= d){
            int i = 0;
            while(n >= (d<<(i+1))){
                i+=1;
            }
            ans += (1L<<i);
            n-=(d<<(i));
        }
        if(ans == (1L<<31) && sign) return Integer.MAX_VALUE;
        if(ans == (1L<<31) && !sign) return Integer.MIN_VALUE;
        
        return (int)(sign ? ans : -ans);
    }
}