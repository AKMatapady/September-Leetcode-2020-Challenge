class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        for(char x: t.toCharArray())
        {
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        for(char x: s.toCharArray())
        {
            int y = mp.getOrDefault(x, 0);
            if(y == 1)
            {
                mp.remove(x);
            }
            else
                mp.put(x, y-1);
        }
        for(char x: mp.keySet())
            return x;
        return 'a';
    }
}