class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k < 2)
            return 0; 
        int num = 0, prod = 1;
        for(int i = 0, j = 0; j < nums.length; j++)
        {
            prod *= nums[j];
            while(prod >= k)
            {
                prod /= nums[i];
                i++;
            }
            num += (j-i+1);
        }
        return num;
    }
}