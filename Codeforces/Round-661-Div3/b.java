import java.util.*;
public class b {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0){
            int size = in.nextInt();
            long[] arr = new long[size];
            long[] arr2 = new long[size];
            long min1 = Integer.MAX_VALUE;
            long min2 = Integer.MAX_VALUE;
            for (int i = 0 ; i < size; i++){
                arr[i] = in.nextLong();
                if (arr[i] < min1) min1 = arr[i];
            }
            for (int i = 0; i < size; i++){
                arr2[i] = in.nextLong();
                if (arr2[i] < min2) min2 = arr2[i];
            }
            eval(arr, arr2, min1, min2);
        }
        in.close();
    }
    private static void eval(long[] arr1, long[] arr2, long min1, long min2){
        for (int i = 0 ; i < arr1.length; i++){
            arr1[i] = arr1[i] - min1;
            arr2[i] = arr2[i] - min2;
        }
        long sum = 0;
        for (int i = 0 ; i < arr1.length; i++){
            sum += Math.max(arr1[i], arr2[i]);
        }
        System.out.println(sum);
    }
}