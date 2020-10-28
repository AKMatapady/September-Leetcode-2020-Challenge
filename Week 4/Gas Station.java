class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length < 1 || cost == null || gas.length != cost.length)
            return -1;
        int len = gas.length, sum = 0;
        for(int i = 0; i < len; i++)
        {
            sum += (gas[i]-cost[i]);
        }
        if(sum < 0)
            return -1;
        int start = 0, curr = 0;
        for(int i = 0; i < len; i++)
        {
            curr += (gas[i] - cost[i]);
            if(curr < 0)
            {
                curr = 0;
                start = i+1;
            }
        }
        return start;
    }
}