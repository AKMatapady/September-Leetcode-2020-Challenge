class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int m = v1.length;
        int n = v2.length;
        int o = Math.min(m,n);
        //System.out.println(o);
        for(int i = 0; i < o; i++)
        {
            //System.out.println(Integer.valueOf(v1[i]) + " " + Integer.valueOf(v2[i]));
            if(Integer.valueOf(v1[i]) < Integer.valueOf(v2[i]))
                return -1;
            if(Integer.valueOf(v1[i]) > Integer.valueOf(v2[i]))
                return 1;
        }
        
        int p = Math.max(m,n);
        
        for(int i = o; i < p; i++)
        {
            if(v1.length > o)
            {
                if(Integer.valueOf(v1[i]) > 0)
                    return 1;
            }
            else
            {
                if(0 < Integer.valueOf(v2[i]))
                    return -1;
            }
        }        
        
        return 0;
    }
}