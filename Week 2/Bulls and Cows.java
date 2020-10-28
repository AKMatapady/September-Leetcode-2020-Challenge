class Solution {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        HashMap<Character, Integer> mp = new HashMap<Character, Integer>();
        for(int i = 0; i < secret.length(); i++)
        {
            if(secret.charAt(i) == guess.charAt(i))
                A++;
            else
            {
                mp.put(secret.charAt(i), mp.getOrDefault(secret.charAt(i), 0)+1);
            }
        }
        for(int i = 0; i < secret.length(); i++)
        {
            if(secret.charAt(i) != guess.charAt(i))
            {
                int x = mp.getOrDefault(guess.charAt(i), 0);
                if(x > 0)
                {
                    //System.out.println(i + " " + x + " " + guess.charAt(i));
                    B++;
                    mp.put(guess.charAt(i), x-1);
                }
            }
        }
        return (A+"A"+B+"B");
    }
}