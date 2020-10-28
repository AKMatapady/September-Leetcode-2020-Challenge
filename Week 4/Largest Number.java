class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length < 1)
            return "0";
        Integer[] n = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++)
            n[i] = nums[i];
        Arrays.sort(n, (a, b) -> {
            String str1 = String.valueOf(a);
            String str2 = String.valueOf(b);
            return (str2+str1).compareTo(str1+str2);
            // for(int i = 0; i < Math.min(str1.length(), str2.length()); i++)
            // {
            //     if(str1.charAt(i) > str2.charAt(i))
            //         return -1;
            //     if(str1.charAt(i) < str2.charAt(i))
            //         return 1;
            // }
            // if(str1.length() > str2.length())
            // {
            //     if(str1.charAt(0) <= str1.charAt(str2.length()))
            //         return -1;
            //     return 1;
            // }
            // else if(str1.length() < str2.length())
            // {
            //     if(str2.charAt(0) <= str2.charAt(str1.length()))
            //         return 1;
            //     return -1;
            // }
            // return 0;
        });
        if(n[0] == 0)
            return "0";
        //System.out.println(n[0]);
        StringBuilder sb = new StringBuilder();
        for(int x: n)
        {
            sb.append(String.valueOf(x));
        }
        
        return sb.toString();
    }
}