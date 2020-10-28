class Solution {
    
//     private int recur(int i, int sum, boolean prev)
//     {
//         if(i == n.length)
//             return sum;
//         int a = 0, b = 0;
//         if(!prev)
//             a = recur(i+1, sum+n[i], true);
//         b = recur(i+1, sum, false);
//         return Math.max(a,b);
//     }
    
//     int[] n;
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        //n = nums;
        int ans = 0;
        
        int one = nums[0];
        int two = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++)
        {
            int swap = two;
            two = Math.max(one+nums[i], two);
            one = swap;
        }
        
        // int a = recur(1, n[0], true);
        // int b = recur(1, 0, false);
        // ans = Math.max(a, b);
        return two;
    }
}