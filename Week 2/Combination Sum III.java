class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> ans = new ArrayList();
        if(k < 1 || k > 10)
            return ans;
        if(k==1 && n > 9)
            return ans;
        recur(1, n, k, new LinkedList(), ans);
        return ans;
    }
    private void recur(int start, int n, int k, LinkedList<Integer> list, List<List<Integer>> result) 
    {
        if(n == 0 && list.size() == k) 
        {
            result.add(new ArrayList(list));
            return;
        }
        
        for(int i = start; i <= 9; i++) 
        {
            list.add(i);
            recur(i + 1, n - i, k, list, result);
            list.removeLast(); 
        }
    }
}