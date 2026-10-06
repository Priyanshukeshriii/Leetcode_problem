class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) {
            return ans;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {

            Map<String, Integer> currentCount = new HashMap<>();
            int count = 0;
            int start = i;

            for (int j = i; j + wordLength <= s.length(); j += wordLength) {

                String word = s.substring(j, j + wordLength);

                if (wordCount.containsKey(word)) {
                    

                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentCount.get(word) > wordCount.get(word)) {
                        String startWord = s.substring(start, start + wordLength);
                        currentCount.put(startWord, currentCount.get(startWord) - 1);
                        start+=wordLength;
                        count--;
                    }

                    
                    if (count == totalWords) {
                        ans.add(start);
                        String startWord = s.substring(start, start + wordLength);
                        currentCount.put(startWord, currentCount.get(startWord) - 1);

                        start += wordLength;
                        count--;
                    }
                }
                else{
                    count = 0;
                    start = j + wordLength;
                    currentCount.clear();
                }
            }

            
        }

        return ans;
    }
}