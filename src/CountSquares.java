import java.util.HashMap;


public class CountSquares {

    public static void main(String[] args){
        CountSquares n = new CountSquares();
        long startTime = System.currentTimeMillis();
        System.out.println(n.maxNumberSquare(2 , 1000000000));
        System.out.println("Total time =" + (System.currentTimeMillis() - startTime));

    }

    public static int  maxNumberSquare(int a, int b)
    {
        HashMap<Long,Integer> sqrtOpsMap = new HashMap();
        int maxCount = 0;
        for (long i = b ; i >= a ; i--) {
            double floatingSqrrt = Math.sqrt(i);
            Long longSqrrt = Math.round(floatingSqrrt);
            int count = 0;
            if(!sqrtOpsMap.containsKey(longSqrrt)) {
                while ( (floatingSqrrt - longSqrrt == 0) && longSqrrt >= 2) {
                    floatingSqrrt = Math.sqrt(longSqrrt);
                    longSqrrt = Math.round(floatingSqrrt);
                    count++;
                }
                if(count > 0) {
                    sqrtOpsMap.putIfAbsent(i, count);
                    if( count > maxCount ) {
                        maxCount = count;
                    }
                }
            }
        }
        return maxCount;
    }
}
