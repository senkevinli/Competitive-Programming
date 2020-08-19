// Codeforces Round 662 (Div 2), Rainbow Dash, Fluttershy and Chess Coloring
import java.util.*;
public class a1393{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0){
            int grid = in.nextInt();
            System.out.println(eval(grid));
        }
        in.close();
    }
    private static int eval(int grid){
        if (grid == 1) return 1;
        if (grid == 2) return 2;
        return grid/2 + 1;
    }
}