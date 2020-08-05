import java.util.*;
public class c1382 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            in.nextInt();
            in.nextLine();
            String a = in.next();
            String b = in.next();
            List<Integer> ret = eval(a, b);
            for (int j : ret){
                System.out.print(j + " ");
            }
            System.out.println();
        }
        in.close();
    }
    private static List<Integer> eval(String a, String b){
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        StringBuilder sA = new StringBuilder(a);
        StringBuilder sB = new StringBuilder(b);
        if (a.equals(b)) {
            return ret;
        }
        boolean lense = true;
        for (int i = a.length() - 1; i >= 0; i--){
            char first = flip(sA.charAt(0), lense);
            char at = flip(sA.charAt(i), lense);
            if (at == sB.charAt(i)) continue;
            if (first == sB.charAt(i)){
                sA.replace(0, 1, "" + flip(first, false));
                ret.set(0, ret.get(0) +1);
                ret.add(1);
            }
            lense = !lense;
            StringBuilder reversed = new StringBuilder(sA.substring(0, i+1));
            reversed.reverse();
            sA.replace(0, i+1, reversed.toString());
            ret.set(0, ret.get(0) + 1);
            ret.add(i + 1);
        }
        return ret;
    }
    private static char flip(char c, boolean lense){
        if (lense) return c;
        return c == '1' ? '0' : '1';
    }
}