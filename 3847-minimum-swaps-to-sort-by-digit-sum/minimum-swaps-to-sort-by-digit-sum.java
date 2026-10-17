class Solution {
    public int minSwaps(int[] numbers) {
        int length = numbers.length;
        
        // encodedElements stores the digit sum in the high bits, and the actual value in the low bits
        long[] encodedElements = new long[length];  
        for (int i = 0; i < length; i++) {
            encodedElements[i] = (long) calculateDigitSum(numbers[i]) << 32 | numbers[i];
        }
        Arrays.sort(encodedElements);
        
        // sortedIndices tracks the final required position of each original value
        Map<Integer, Integer> sortedIndices = new HashMap<>();  
        for (int pos = 0; pos < length; pos++) {
            sortedIndices.put((int) encodedElements[pos], pos);
        }
        
        // targetIndices tells us where the value currently sitting at index 'i' needs to go
        int[] targetIndices = new int[length];  
        for (int i = 0; i < length; i++) {
            targetIndices[i] = sortedIndices.get(numbers[i]);
        }

        int swapCount = 0;
        for (int i = 0; i < length; i++) {
            // Keep swapping until the correct element is sitting at the current index 'i'
            while (targetIndices[i] != i) {  
                int targetPos = targetIndices[i];
                targetIndices[i] = targetIndices[targetPos];
                targetIndices[targetPos] = targetPos;
                swapCount++;
            }
        }
        return swapCount;
    }

    private int calculateDigitSum(int value) {
        int sum = 0;
        for (; value > 0; value /= 10) {
            sum += value % 10;
        }
        return sum;
    }
}