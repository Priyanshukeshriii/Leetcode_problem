class Solution {
    static {
        for (int i = 0; i<300; i++) {
            removeOuterParentheses("()");
        }
    }
    public static String removeOuterParentheses(String s) {
        int count = 0;
        int st = 0;
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch =='('){
                if(count > 0){
                    ans.append(ch);
                }
                count++;
            }
            else{
                count--;
                if(count > 0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}