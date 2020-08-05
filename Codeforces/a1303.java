import java.util.*;
public class a1303{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        while (tests-- > 0){
            String s = in.next();
            System.out.println(eval(s));
        }
        in.close();
    }
    private static int eval(String s){
        int ones = 0;
        int del = 0;
        for (int i = 0 ; i < s.length(); i++){
            if (s.charAt(i) == '1') ones++;
        }
        boolean met = false;
        for (int i = 0 ; i < s.length(); i++){
            if (!met && s.charAt(i) == '1'){
                met = true;
                ones--;
            } else if (s.charAt(i) == '1'){
                ones--;
            } else if (met && s.charAt(i) == '0' && ones > 0){
                del++;
            }
            
        }
        return del;
    }
}