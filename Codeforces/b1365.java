import java.util.*;
public class b1365{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int num = in.nextInt();
            boolean ascending = true;
            int prev = -1;
            for (int j = 0; j < num ; j++){
                int n = in.nextInt();
                if (n < prev) ascending = false;
                prev = n;
            }
            if (ascending) System.out.println("Yes");
            int zeroes = 0;
            int ones = 0;
            for (int j = 0; j < num; j++){
                int n = in.nextInt();
                if (n == 1) ones++;
                else zeroes++;
            }
            if (!ascending && (zeroes == 0 || ones == 0)) System.out.println("No");
            else if (!ascending) System.out.println("Yes");
        }
        in.close();
    }
}