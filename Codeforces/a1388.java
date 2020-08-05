import java.util.*;
public class a1388 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int n = in.nextInt();
            int[] result = eval(n);
            if (result == null) System.out.print("NO");
            else{
                System.out.println("YES");
                for (int j : result) System.out.print(j + " ");
            }
            System.out.println();
        }
        in.close();
    }
    private static int[] eval(int n){
        int diff = n - 30;
        if (diff <= 0) return null;
        if (diff == 6 || diff == 10 || diff == 14){
            return new int[]{6, 10, 15, n - 31};
        } else return new int[]{6, 10, 14, diff};
    }
}