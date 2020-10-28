class Solution {
    public boolean wordPattern(String pattern, String str) {
        int plen = pattern.length();
        String[] arr = str.split(" ");
        
        if(plen != arr.length)
            return false;
        
        // //index -> Character
        // HashMap<Integer, Character> mp1 = new HashMap<Integer, Character>();
        //Character -> word
        HashMap<Character, String> mp2 = new HashMap<Character, String>();
        HashMap<String, Character> mp3 = new HashMap<String, Character>();
        
        
        // for(int i = 0; i < plen; i++)
        // {
        //     mp1.put(i, pattern.charAt(i));
        // }
        
        int index = 0;
        
        for(String s: arr)
        {
            char ch = pattern.charAt(index);
            String sub = mp2.get(ch);
            if(sub == null)
            {
                Character c = mp3.get(s);
                if(c == null)
                {
                    mp2.put(ch, s);
                    mp3.put(s, ch);
                }
                else
                    return false;
            }
            else
            {
                if(!sub.equals(s))
                {
                    //System.out.println(index + " " + s + " " + sub);
                    return false;
                }
            }
            index++;
            index = index % plen;
        }
        return true;
    }
}