import java.util.HashMap;

class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int globalMax = 0;
        int left = 0; // This marks the start of our current valid substring
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // 1. Add the character to the map or increment its count
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            
            // 2. If the current character appears more than 2 times, 
            // shrink the window from the left until it is valid again.
            while (map.get(c) > 2) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++; // Move the start of the substring forward
            }
            
            // 3. Calculate current max length and update global max
            int currentMax = right - left + 1;
            
            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }
        
        return globalMax;
    }
}