import java.util.Scanner;
public class d1385 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests > 0){
            int size = in.nextInt();
            String letters = in.next();
            char c = 'a';
            System.out.println(helper(size, letters, c));
            tests--;
        }
        in.close();
    }
    private static int helper(int size, String letters, char c){
        if (size == 1){
            return c == letters.charAt(0) ? 0 : 1;
        }
        int toChangeLeft = 0;
        for (int i = 0 ; i < letters.length()/2; i++){
            if (c != letters.charAt(i)) toChangeLeft++;
        }
        int left = toChangeLeft + helper(size/2, letters.substring(size/2, size), (char)(c + 1));
        int toChangeRight = 0;
        for (int i = letters.length()/2; i < letters.length(); i++){
            if (c != letters.charAt(i)) toChangeRight++;
        }
        int right = toChangeRight + helper(size/2, letters.substring(0 , size/2), (char) (c + 1));
        return Math.min(left, right);
    }
}