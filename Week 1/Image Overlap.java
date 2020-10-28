class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        int x = A.length*2-1;
        int[][] overlaps = new int[x][x];
        int shift = A.length-1;
        for (int i=0; i<A.length; i++) 
        {
            for (int j=0; j<A.length; j++) 
            {
                if (A[i][j] == 0) 
                {
                    continue;
                }
                for (int k=0; k<B.length; k++) 
                {
                    for (int l=0; l<B.length; l++) 
                    {
                        if (B[k][l] == 0) 
                        {
                            continue;
                        }
                        int count = ++overlaps[k-i+shift][l-j+shift];
                        if(count > max)
                            max = count;
                    }
                }   
            }
        }
        return max;
    }
}