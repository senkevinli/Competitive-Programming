// solution based off of editorial, really hard permutation problem!

import java.util.*;
public class c1391{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = 1;
        while (tests-- > 0){
            int n = in.nextInt();
            System.out.println(eval(n));
        }
        in.close();
    }
    private static long eval(int n){
        // answer is n! - 2^(n-1)
    }
}