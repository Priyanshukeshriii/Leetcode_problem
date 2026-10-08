class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        int st = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '('){
                if(count > 0){
                    ans.append('(');
                }
                count++;
            }else{
                count--;
                if(count > 0 ){
                    ans.append(')');
                }
            }

            
        }
        return ans.toString();
    }
}