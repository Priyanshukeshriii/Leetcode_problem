class Solution {
    public String convert(String s, int n) {
        int size = s.length();

        if(s.length() == n) return s;
        if(n == 1 ) return s;
        
        StringBuilder sb = new StringBuilder();
        for(int j = 0 ; j < n ; j ++){
            int  i = 0;
            while(i< size && ((((2*n) -2)*i) +j) < size){
                int next_Index =  (((2*n) -2)*i)+j;
                if(j == 0 || j == n-1){
                    sb.append(s.charAt(next_Index)); 
                }else{
                    sb.append(s.charAt(next_Index));
                    if((next_Index+(n-j-1)*2)  <size ){
                        sb.append(s.charAt(next_Index+(n-j-1)*2));
                    }
                }
                i++;
            }
            
        }
        return sb.toString();
    }
}