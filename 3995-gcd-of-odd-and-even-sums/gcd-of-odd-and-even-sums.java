class Solution {
    public int gcdOfOddEvenSums(int n) {
        // sum of n odd number is n(n+1)
        // sum of n odd number is n^2
        // gcd of (n^2 , n(n+1))
        // take n common
        // n * gcd(n , (n+1))
        // the gcd of gcd(n , (n+1)) = 1
        // finally n *1 = n
        return n;
    }
}