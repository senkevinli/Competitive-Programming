import java.util.*;
public class c1366 {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int height = in.nextInt();
            int width = in.nextInt();
            int[][] mat = new int[height][width];
            for (int x = 0; x < height; x++){
                for (int y = 0; y < width; y++){
                    mat[x][y] = in.nextInt();
                }
            }
            int comb = height + width;
            System.out.println(eval(mat, comb));
        }
        in.close();
    }
    private static int eval(int[][] mat, int comb){
        int toChange = 0;
        int lim = (comb - 1)/2;
        for (int i = 0 ; i < lim; i++){
            int tally = 0;
            int total = 0;
            for (int j = 0 ; j <= i; j++){
                int x = j;
                int y = i - j;
                if (x > mat.length - 1 || y >  mat[0].length - 1) continue;
                //System.out.println(x + " " + y);
                tally += mat[x][y] + mat[mat.length - x - 1][mat[0].length - y - 1];
                total+=2;
            }
            toChange += Math.min(tally, total - tally);
        }
        return toChange;
    }
}