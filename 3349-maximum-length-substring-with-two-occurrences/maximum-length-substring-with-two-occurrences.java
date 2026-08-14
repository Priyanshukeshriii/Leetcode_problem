class Solution {
    public int maximumLengthSubstring(String s) {
        // Use an array of size 26 instead of a HashMap
        int[] count = new int[26]; 
        
        int globalMax = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Map character 'a' to index 0, 'b' to 1, ..., 'z' to 25
            int charIndex = s.charAt(right) - 'a';
            
            // 1. Increment the count of the current character
            count[charIndex]++;
            
            // 2. Shrink window if the count exceeds 2
            while (count[charIndex] > 2) {
                int leftCharIndex = s.charAt(left) - 'a';
                count[leftCharIndex]--;
                left++;
            }
            
            // 3. Update global max
            int currentMax = right - left + 1;
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }
        
        return globalMax;
    }
}