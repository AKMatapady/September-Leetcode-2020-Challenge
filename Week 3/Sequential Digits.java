class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
     String all = "123456789";
        List<Integer> ans = new ArrayList();

    int ll = String.valueOf(low).length();
    int hl = String.valueOf(high).length();
    for (int i = ll; i < hl + 1; i++) 
    {
      for (int j = 0; j < 10 - i; j++) 
      {
        int n = Integer.parseInt(all.substring(j, j + i));
        if (n >= low && n <= high) 
            ans.add(n);
      }
    }
    return ans;
    }
}