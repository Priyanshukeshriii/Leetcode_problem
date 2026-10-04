class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.isEmpty()) return false; 
        

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
        Stack openstack = new Stack(s.length());
        Stack starstack = new Stack(s.length());
        
        for(int i = 0 ; i < s.length() ; i++){
            char b = s.charAt(i);
            if(b == '('){
                openstack.push(i);
            }
            else if (b == '*'){
                starstack.push(i);
            }else{
                if(!openstack.isEmpty()){
                    openstack.pop();
                }else if(!starstack.isEmpty()){
                    starstack.pop();
                }else{
                    return false;
                }
            }
        }
        while (!openstack.isEmpty() && !starstack.isEmpty()) {
            int openIndex = openstack.pop();
            int starIndex = starstack.pop();
    
            if (openIndex > starIndex) {
                return false;
            }
        }

        return openstack.isEmpty();
    }
}






