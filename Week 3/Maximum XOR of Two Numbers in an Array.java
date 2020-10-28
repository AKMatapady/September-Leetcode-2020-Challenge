class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, max = 0;
        for(int i = 31; i > -1; i--)
        {
            mask = mask | (1 << i);
            Set<Integer> st = new HashSet<Integer>();
            for(int x: nums)
                st.add(x & mask);
            int temp = max | (1 << i);
            for(int x: st)
            {
                if(st.contains(temp ^ x))
                {
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
}