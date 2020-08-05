import java.util.*;
public class a1382 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0; i < tests; i++){
            int first = in.nextInt();
            int second = in.nextInt();
            eval(in, first, second);
            
        }
        in.close();
    }
    private static void eval(Scanner in, int first, int second){
        Set<Integer> s = new HashSet<>();
        for (int j = 0; j < first; j++){
            s.add(in.nextInt());
        }
        boolean hit = false;
        for (int j = 0 ; j < second; j++){
            int a = in.nextInt();
            if (s.contains(a)){
                System.out.println("YES");
                System.out.println(1 + " " + a);
                return;
            }
        }
        if (!hit){
            System.out.println("NO");
        }
    }
}