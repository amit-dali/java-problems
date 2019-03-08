import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class FarthestDistance {

    public static void main(String[] args){
        FarthestDistance n = new FarthestDistance();
        int arr[] = IntStream.rangeClosed(0, 15000).toArray();
        arr[3000] = 2;
        arr[5000] = 3;
        arr[6000] = 2;
        arr[14500] = 2;
                //{8,7,3,4,7,5,3,9,3,7,9,0};
                //{3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};

        long startTime = System.currentTimeMillis();
        System.out.println(n.solution(arr));
        System.out.println("Total time =" + (System.currentTimeMillis() - startTime));

    }

    int solution(int[] A) {
        HashMap<Integer, Integer> tempMap = new HashMap();
        int maxDistance = 0;
        final int arrLen = A.length;
        for (int i = 0 ; i < arrLen; i++)
        {
            if(tempMap.putIfAbsent(A[i], i) != null){
                maxDistance = Math.max(maxDistance, i - tempMap.get(A[i]));
            }
        }
        return maxDistance;
    }
}
