class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        Arrays.sort(timeSeries);
        int end = 0;
        int ans = 0;
        
        for(int x: timeSeries)
        {
            int y = Math.min(duration, x+duration-end);
            end = Math.max(end, x+duration);
            if(y > 0)
            ans += y;
        }
        return ans;
    }
}