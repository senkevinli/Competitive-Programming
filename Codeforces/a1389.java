import java.util.*;
public class a1389 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int l = in.nextInt();
            int r = in.nextInt();
            int[] arr = eval(l, r);
            for (int j :  arr) System.out.print(j + " ");
            System.out.println();
        }
        in.close();
    }
    private static int[] eval(int l, int r){
        int ans = l*2;
        if (ans <= r) return new int[]{l, ans};
        return new int[]{ -1, -1};
    }
}