import java.util.*;

public class b1388{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int digits = in.nextInt();
            eval(digits);
            System.out.println();
        }
        in.close();
    }
    private static void eval(int digits){
        int eights = (int) Math.ceil((1.0 * digits)/4);
        int nines = digits - eights;
        for (int i = 0; i < nines; i++){
            System.out.print(9);
        }
        for (int i = 0 ; i < eights; i++){
            System.out.print(8);
        }
    }
}