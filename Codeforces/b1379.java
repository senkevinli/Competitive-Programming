import java.util.*;
public class b1379 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long tests = in.nextLong();
        while (tests > 0){
            long left = in.nextLong();
            long right = in.nextLong();
            long encrypt = in.nextLong();
            long[] arr = eval(left, right, encrypt);
            for (long i : arr) System.out.print(i + " ");
            System.out.println();
            tests--;
        }
        in.close();
    }
    private static long[] eval(long left, long right, long encrypt){
        long range = right - left; // can be positive or negative

        for (long i = left; i <= right; i++){
            // decrease
            if ( encrypt >= i){
                long rem = nearMult(encrypt, i) - encrypt;
                if (Math.abs(rem) <= range){
                    if (rem < 0){
                        long c = left;
                        return new long[]{i, c+Math.abs(rem), c};
                    } else {
                        long b = left;
                        return new long[]{i, b, b+Math.abs(rem)};
                    }
                    
                }
            } else {
                long rem = i - encrypt; // c - b = rem
                return new long[]{i, left, left+rem};
            }
        }
        return null;
    }
    private static long nearMult(long n, long x){
       if (x > n) return x;
        n = n + x/2;
        n = n - (n%x);
        return n;
    }
}