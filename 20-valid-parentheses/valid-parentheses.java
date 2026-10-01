

class Solution {
    public boolean isValid(String s) {
        if (s == null || (s.length() % 2) == 1) return false; // odd length can't be valid

        class Stack{
            int p , l;
            char[] stack;
            Stack( int length){
                p = -1;
                l = length;
                stack = new char[l];
            }
            public void push(char e){
                stack[++p] = e;
            }
            public char pop(){
                if(p < 0){
                    return ' ';
                }else{
                    return stack[p--];
                }
            }
            public boolean isEmpty(){
                return p ==-1;
            }
        }
        Stack stack = new Stack(s.length());
        
        for(int i = 0 ; i < s.length() ; i++){
            char  b =s.charAt(i);  
            if(b == '[' || b == '{' || b =='(' ){
                stack.push(b);
            }else {
                char sb = stack.pop();
                if(!((sb == '[' && b == ']') || (sb == '{' && b == '}') || (sb == '(' && b == ')')) ){
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }
}