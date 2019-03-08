public class Neckless {

    public static void main(String[] args){
        Neckless n = new Neckless();
            int[] input = new int[0];
                 //{5,4,0,3,1,6,2};
                 //{1,2,3,4,5,6,7,8,9,1}
                //{1, 0, 4, 2, 3};
                 //{5,4,0,3,1,6,2}
        long startTime = System.currentTimeMillis();
        startTime = System.nanoTime();
        System.out.println(n.solution(input));
        System.out.println("Total time =" + (System.nanoTime() - startTime));
    }


    private int maxChain(int A[], int init, int max)
    {
        int chainMax = 0;
        final int ARR_LEN = A.length;
        if(init >= 0 && init < ARR_LEN) {
            while (init < ARR_LEN && A[init] != -1)
            {
                chainMax++;
                int temp = A[init];
                A[init] = -1;
                init = temp;
            }
            max = (chainMax > max) ? chainMax : max;
        }
        return max;
    }

    public int solution(int[] A)
    {
        if( A == null)
            return 0;

        int max = 0, maxTemp = 0;
        final int ARR_LEN = A.length;
        for (int i = 0; i < ARR_LEN; i++)
        {
            maxTemp = maxChain(A, i, max);
            max = maxTemp > max ? maxTemp : max;
        }
        return max;
    }
 }
