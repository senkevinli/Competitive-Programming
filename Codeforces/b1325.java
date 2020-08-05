import java.util.*;
public class b1325{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        
        for (int i = 0 ; i < tests; i++){
            Set<Integer> s = new HashSet<Integer>();
            int num = in.nextInt();
            for (int j = 0; j < num; j++){
                s.add(in.nextInt());
            }
            System.out.println(s.size());
        }
        in.close();
    }
}