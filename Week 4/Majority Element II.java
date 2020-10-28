class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> ans = new ArrayList();
        if(nums == null || nums.length < 1)
            return ans;
        if(nums.length < 3)
        {
            ans.add(nums[0]);
            if(nums.length == 2 && nums[1] != nums[0])
                ans.add(nums[1]);
            return ans;
        }
        
        Integer x1 = null, c1 = 0, x2 = null, c2 = 0;
        //int i = 1;
        // while(nums[i] == x1 && i < nums.length)
        // {
        //     c1++;
        // }
        // if(i < nums.length)
        // {
        //     x2 = nums[i];
        //     c2 = 1;
        //     i++;
        // }
        
        for(int i = 0; i < nums.length; i++)
        {
            if(x1 != null && nums[i] == x1)
                c1++;
            else if(x2 != null && nums[i] == x2)
                c2++;
            else if(c1 == 0)
                {
                    x1 = nums[i];
                    c1 = 1;
                }
                else if(c2 == 0)
                {
                    x2 = nums[i];
                    c2 = 1;
                }
                else
                {
                    c1--;
                    c2--;
                }
        }
        
        c1 = 0; c2 = 0;
        
        for(int x: nums)
        {
            if(x1 != null && x == x1)
                c1++;
            else if(x2 != null && x == x2)
                c2++;
        }
        
        if(c1 > (nums.length/3))
                ans.add(x1);
        
        if(c2 > (nums.length/3))
                ans.add(x2);
        
//         if(c1 > 0)
//         {
//             int count  = 0;
//             for(int x: nums)
//             {
//                 if(x == x1)
//                     count++;
//             }
//             if(count > (nums.length/3))
//                 ans.add(x1);
//         }
        
//         if(c2 > 0)
//         {
//             int count  = 0;
//             for(int x: nums)
//             {
//                 if(x == x2)
//                     count++;
//             }
//             if(count > (nums.length/3))
//                 ans.add(x2);
//         }
        
        
        return ans;
    }
}