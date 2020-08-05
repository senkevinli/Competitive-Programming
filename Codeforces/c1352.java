import java.util.*;
public class c1352 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            long n = in.nextLong();
            long k = in.nextLong();
            System.out.println(eval(n, k));
        }
        in.close();
    }
    private static long eval(long n , long k){
        return k + ((k-1)/(n-1));
    }
}