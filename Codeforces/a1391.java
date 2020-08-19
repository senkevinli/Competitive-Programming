import java.util.*;
public class a1391{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0){
            int n = in.nextInt();
            eval(n);
        }
        in.close();
    }
    private static void eval(int n){
        for (int i = 0 ; i < n; i++){
            System.out.print(i+1 + " ");
        }
        System.out.println();
    }
}