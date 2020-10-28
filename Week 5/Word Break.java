class Solution {
    
    private boolean recur(int start)
    {
        if(start == a.length())
            return true;
        for(int i = start+1; i <= a.length(); i++)
        {
            if(dict.contains(a.substring(start, i)) && recur(i))
            {
                return true;
            }
        }
        return false;
    }
    
    Set<String> dict;
    String a;
    
    public boolean wordBreak(String s, List<String> wordDict) 
    {        
        dict = new HashSet<String>();
        a = s;
        for(String str: wordDict)
        {
            dict.add(str);
        }
        
        if(dict.contains(s))
            return true;
        
//         for(int i = 1; i<= s.length(); i++)
//         {
//             if(dict.contains(s.substring(0, i)) && recur(i))
//             {
//                 return true;
//             }
//         }
        
//         return false;
        
        Boolean[] dp = new Boolean[a.length()+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int end = 1; end <= a.length(); end++)
        {
            for(int start = 0; start < end; start++)
            {
                if(dp[start] && dict.contains(a.substring(start, end)))
                {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[a.length()];
    }
}