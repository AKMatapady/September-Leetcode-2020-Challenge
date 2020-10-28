class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList();
        if(intervals.length < 1)
        {
            ans.add(newInterval);
            return ans.toArray(int[][]::new);
        }
        boolean f = false, d = false;
        if(intervals[0][0] > newInterval[1])
        {
            ans.add(newInterval);
            d = true;
        }
        
        int start = newInterval[0], end = newInterval[1];
        for(int[] x: intervals)
        {
            if(!f && !d && x[0] > newInterval[1])
            {
                ans.add(newInterval);
                d = true;
            }
            if(x[0] > newInterval[1] || x[1] < newInterval[0] )
            {
                if(f)
                {
                    f = !f;
                    d = true;
                    ans.add(new int[]{start, end});
                }
                ans.add(x);
            }                    
            else                    
            {
                f = true;
                start = Math.min(start, x[0]);
                end = Math.max(end, x[1]);
            }
        }
        if(f)
        {
            f = !f;
            d = true;
            ans.add(new int[]{start, end});
        }
        if(intervals[intervals.length-1][1] < newInterval[0])
            ans.add(newInterval);
        return ans.toArray(int[][]::new);
    }
}