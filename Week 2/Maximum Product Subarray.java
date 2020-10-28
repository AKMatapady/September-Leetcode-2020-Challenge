class Solution {
    
    private int find(int start, int end)
    {
        if(start >= end)
            return 0;
        if(start == (end-1))
            return a[start];
        int left = -1, right = -1, count = 0, prod = 1, lp = -1, rp=-1;
        for(int i = start; i < end; i++)
        {
            prod *= a[i];
            if(a[i] < 0)
            {
                count++;
                if(left < 0)
                {
                    left = i;
                    lp = (prod/a[i]);
                }
                right = i;
                rp=-1;
            }
            if(right < i)
            {
                rp *= a[i];
            }
        }
        if(prod > 0)
            return prod;
        int next = 0;
        int b = (prod/lp)/a[left];
        if(b>lp)
            next = b;
        else
            next = lp;
        if(right > left)
        {
            rp *= -1;
            b = (prod/rp)/a[right];
            if(b>next)
                next = b;
            if(rp > next)
                next = rp;
        }
        return next;
    }
    
    int[] a;
    int maxSoFar;
    int current;
    
    public int maxProduct(int[] nums) {
        maxSoFar = Integer.MIN_VALUE;
        current = 0;
        a = nums;
        int start = 0;
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] == 0)
            {
                current = find(start, i);
                start = i+1;
            }
            else if(i == (a.length-1))
            {
                current = find(start, i+1);
            }
            if(current > maxSoFar)
                maxSoFar = current;
        }
        return maxSoFar;
    }
}