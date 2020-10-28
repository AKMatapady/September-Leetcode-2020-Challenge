class Solution {
    public int firstMissingPositive(int[] nums) {
        
        if(nums == null || nums.length < 1)
            return 1;
        
        boolean one = false;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
            {
                one = true;
                break;
            }
        }
        if(!one)
            return 1;
        
        if(nums.length == 1)
            return 2;
        
        for(int i = 0; i< nums.length; i++)
        {
            if(nums[i] < 1 || nums[i] > nums.length)
                nums[i] = 1;
        }
        
        for(int i = 0; i< nums.length; i++)
        {
            int n = Math.abs(nums[i]);
            
            nums[n%nums.length] = - Math.abs(nums[n%nums.length]);
        }
        
        for(int i = 1; i<= nums.length; i++)
        {
            if(nums[i%nums.length] > 0)
                return i;
        }
        return  (nums.length+1);
    }
}