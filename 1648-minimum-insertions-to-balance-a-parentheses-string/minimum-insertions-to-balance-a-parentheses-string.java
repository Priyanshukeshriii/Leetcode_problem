class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int count = 0;
        for(char e : s.toCharArray()){
            if(e == '(') {
                if((ans & 1) == 1){
                    count++;
                    ans++;
                }
                ans -= 2;
            }
            else {
                if(ans == 0){
                    ans -= 2;
                    count++;
                }
                ans+=1;
            }
        }
        return Math.abs(ans) + count;        
    }
}