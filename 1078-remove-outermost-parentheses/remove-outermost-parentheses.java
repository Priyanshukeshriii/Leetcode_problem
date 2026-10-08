class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        int st = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                count++;
            }else{
                count--;
            }

            if(count == 0){
                ans.append(s.substring(st+1,i));
                st = i+1;
            }
        }
        return ans.toString();
    }
}