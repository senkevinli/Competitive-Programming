package Codeforces;

import java.util.*;
public class a1343{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int n = in.nextInt();
            System.out.println(eval(n));
        }
        in.close();
    }
    private static int eval(int n){
        for (int i = 3 ; i <= n; i = i*2 + 1){
            if (n % i == 0) return n/i;
        }
        return -1;
    }
}