import java.util.*;
public class c1374{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int n = in.nextInt();
            in.nextLine();
            System.out.println(eval(in.next()));
        }
        in.close();
    }
    private static int eval(String s){
        int left = 0;
        int resolved = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                left++;
            } else if (s.charAt(i) == ')'){
                if (left > 0){
                    left--;
                    resolved += 2;
                }
            }
        }
        return (s.length() - resolved)/2;
    }
}