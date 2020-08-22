package Codeforces;

import java.util.*;
public class b1343{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int n = in.nextInt();
            if ( (n/2) % 2 == 1) System.out.println("NO");
            else {
                System.out.println("YES");
                long[] result = eval(n);
                for (long j : result) System.out.print(j +  " ");
                System.out.println();
            }
        }
        in.close();
    }
    private static long[] eval(int n){
        long[] ret = new long[n];
        long second = 1;
        long val = 0;
        for (int i = 0 ; i < n/2; i++){
            val = val+2;
            second = second+2;
            ret[i] = val;
            if (i == n/2 - 1){
                ret[i+n/2] = val + ((n/2) - 1);
            } else {
                ret[i+n/2] = second;
            }
            

        }
        return ret;
    }
}