import java.util.*;
public class a1374{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            int n = in.nextInt();
            System.out.println(eval(x, y, n));
        }
        in.close();
    }
    private static int eval(int x, int y, int n){
        int rem = n % x;
        if (rem == y) return n;
        if (rem > y) return n - (rem - y);
        return n - rem - (x - y);
    }
}