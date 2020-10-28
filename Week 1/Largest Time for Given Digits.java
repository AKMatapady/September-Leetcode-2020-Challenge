class Solution {
    public String largestTimeFromDigits(int[] A) {
        int min = A[0], max = -1;
        for(int i = 1; i < 4; i++)
        {
            if(min > A[i])
                min = A[i];
            // if(max < A[i])
            //     max = A[i];
        }
        if(min > 2)
            return "";
                
        String result = "";
        boolean[] done = new boolean[4];
        
        for(int i = 0; i< A.length; i++) 
        {
            for(int j = 0; j< A.length; j++) 
            {
                if(i!=j) 
                {
                    int hh = A[i]*10 + A[j];
                    if(hh>=0 && hh<24) 
                    {
                        done[i] = true;
                        done[j] = true;
                        for(int m = 0; m<A.length; m++) 
                        {
                            for(int n = 0; n< A.length; n++) 
                            {
                                if(m!=n && !done[m] && !done[n]) 
                                {
                                    int mm = A[m]*10 + A[n];
                                    if(mm>=0 && mm<60) 
                                    {
                                        int epoch = hh * 60 + mm;
                                        if(epoch > max) 
                                        {
                                            max = epoch;
                                            result  = A[i]+""+A[j]+":"+A[m]+""+A[n];
                                        }
                                    }
                                }
                            }
                        }
                        done[i] = false;
                        done[j] = false;
                    }
                }
            }
        }
        return result;
        
    }
}