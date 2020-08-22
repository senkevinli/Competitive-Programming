//unfinished
import java.util.*;
public class c948{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int piles = in.nextInt();
        long[] p = new long[piles];
        long[] t = new long[piles];
        for (int i = 0 ;i < piles; i++){
            p[i] = in.nextInt();
        }
        for (int i = 0 ;i < piles ;i++){
            t[i] = in.nextInt();
        }
        long[] result = eval(p, t);
        for (long l : result){
            System.out.print(l + " ");
        }
        in.close();
    }
    private static long[] eval(long[] p , long[] t){
        long[] preSum = new long[p.length];
        long[] pilesLeft = new long[p.length];
        long[] dis = new long[p.length];
        long curr = 0;
        for (int i = 0 ; i < p.length; i++){
            preSum[i] = curr + t[i];
            curr = preSum[i];
        }
        for (int i = 0 ; i < p.length; i++){
            int j = bin(p[i], preSum, i);
            System.out.println(p[i] + " " + j);
            for (int k = i; k <= j; k++){
                pilesLeft[k]++;
            }
            if (j < p.length && preSum[j] > p[i]){
                dis[j] = preSum[j] - p[i];
            }
            
        }
        long[] result = new long[p.length];
        for (int i = 0 ; i < p.length; i++){
            result[i] = t[i]*pilesLeft[i] + dis[i];
        }
        return result;
    }
    private static int bin(long n, long[] preSum, int begin){
        int start = begin;
        int end = preSum.length - 1;
        while (start <= end){
            int mid = (start + end)/2;
            if (preSum[mid] == n){
                return mid;
            } else if (preSum[mid] > n){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}    