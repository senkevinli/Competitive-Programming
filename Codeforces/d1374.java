import java.util.*;
public class d1374 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int size = in.nextInt();
            int k = in.nextInt();
            long[] arr = new long[size];
            for (int j = 0 ; j < size; j++){
                arr[j] = in.nextInt();
            }
            System.out.println(eval(arr, k));
        }
        in.close();
    }
    private static long eval(long[] arr, int k){
        long[] deficit = new long[arr.length];
        for (int i = 0; i < arr.length; i++){
            deficit[i] = ((long) Math.ceil((1.0*arr[i])/k))*k - arr[i];
        }
        Map<Long, Long> taken = new HashMap<>();
        long max = 0;
        for (int i = 0; i < deficit.length; i++){
            if (deficit[i] != 0){
                if (taken.containsKey(deficit[i])){
                    taken.put(deficit[i], taken.get(deficit[i]) + 1);
                    deficit[i] += taken.get(deficit[i])*k;
                } else {
                    taken.put(deficit[i], new Long(0));
                }
                
                if (deficit[i] > max) max = deficit[i];
            }
        }
        if (taken.size() == 0) return 0;
        return max + 1;
    }
}