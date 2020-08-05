
import java.util.*;
public class c1389 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        for (int i = 0 ; i < tests; i++){
            // char[] s = in.next().toCharArray();
            String s = in.next();
            System.out.println(eval(s));
        }
        in.close();
    }
    // good means even and repeating or odd and all the same
    private static int eval(String s){
        if (s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!set.contains(c)) set.add(c);
        }
        int max = 0;
        for (char c : set){
            for (char c2 : set){
                boolean flag = true;
                int temp = 0;
                char looking = help(c, c2, flag);
                for (int i = 0; i < s.length(); i++){
                    if (s.charAt(i) == looking){
                        temp++;
                        flag = !flag;
                        looking = help(c, c2, flag);
                    }
                }
                if (c != c2 && temp % 2 == 1) temp--;
                if (temp > max) max = temp;
            }
        }
        return s.length() - max;
    }
    private static char help(char c, char c2, boolean b){
        if (b) return c;
        return c2;
    }
}