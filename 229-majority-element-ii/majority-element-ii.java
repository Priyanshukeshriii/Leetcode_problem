class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int size = nums.length;
        int el1 = Integer.MIN_VALUE , el2 =Integer.MIN_VALUE;
        int c1 = 0 , c2 =0;
        for(int i = 0 ; i < size ;i++){
            if(c1 == 0 && el2 != nums[i]){
                el1 = nums[i];
                c1 =1;
            }else if(c2 == 0 && el1 != nums[i]){
                el2 = nums[i];
                c2=1;
            }else if(el1 == nums[i]){
                c1++;
            }else if(el2 == nums[i]){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        c1 = 0 ;
        c2 = 0;
        for(int i = 0;i < size ;i ++ ){
            if(el1 == nums[i]){
                c1++;
            }else if(el2 == nums[i]){
                c2++;
            }
        }
        if (c1 > size/3) ans.add(el1);
        if (c2 > size/3) ans.add(el2);
        return ans;
    }
}