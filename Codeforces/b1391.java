import java.util.*;
public class b1391{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0){
            int rows = in.nextInt();
            int cols = in.nextInt();
            in.nextLine();
            char[][] conv = new char[rows][cols];
            for (int i = 0; i < rows; i++){
                String taken = in.next();
                for (int j = 0 ; j < cols; j++){
                    conv[i][j] = taken.charAt(j);
                }
            }
            System.out.println(eval(conv));
        }
        in.close();
    }
    private static int eval(char[][] conv){
        int changed = 0;
        for (int i = 0; i < conv[0].length - 1; i++){
            if (conv[conv.length - 1][i] != 'R')
                changed++;
        }
        for (int i = 0; i < conv.length - 1; i++){
            if (conv[i][conv[0].length - 1] != 'D'){
                changed++;
            }
        }
        return changed;
    }
}