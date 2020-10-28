class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        
        if(prices == null || prices.length < 2)
            return ans;
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < prices.length; i++)
        {
            if(ans < (prices[i] - min))
                ans = (prices[i] - min);
            if(prices[i] < min)
                min = prices[i];
        }
        
        return ans;
    }
}