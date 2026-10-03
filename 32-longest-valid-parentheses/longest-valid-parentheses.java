class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) return 0; 
        int max_len= 0;
        int len = 0;
        class Stack {
    int p, l;
    int[] stack;

    Stack(int length) {
        p = -1;
        l = length;
        stack = new int[l]; 
    }

    public void push(int e) {
        stack[++p] = e;
    }

    public int pop() {
        if (p < 0) {
            return -1;
        } else {
            return stack[p--];
        }
    }

    public int peek() {
        if (p < 0) {
            return -1;
        } else {
            return stack[p];
        }
    }

    public boolean isEmpty() {
        return p == -1;
    }

    public int length() {
        return p + 1;
    }
}
        Stack stack = new Stack(s.length()+1);
        stack.push(-1);
        
        for(int i = 0 ; i < s.length() ; i++){
            
            char  b =s.charAt(i);  
            if(b =='(' ){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    len = i - stack.peek();
                    max_len = Math.max(max_len , len);
                };
            }
            

        }
        

        return max_len;
    }
}


