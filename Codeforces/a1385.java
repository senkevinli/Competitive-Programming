import java.util.*;
public class a1385{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests > 0){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            if (x == y && y == z){
                System.out.println("Yes");
                System.out.println(x + " " + x + " " + x);
            } else if (x == y && x > z || x == z && x > y || z == y && z > x){
                System.out.println("Yes");
                System.out.println(Math.max(x, Math.max(y, z)) + " " + Math.min(x, Math.min(y, z)) + " "+ 1);
            } else {
                System.out.println("No");
            }
            tests--;
        }
        in.close();
    }
}