import java.util.*;
public class b1384 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests > 0){
            int depths = in.nextInt();
            int[] dArr = new int[depths];
            int cycle = in.nextInt();
            int limit = in.nextInt();
            for (int i = 0 ; i < depths; i++){
                dArr[i] = in.nextInt();
            }
            boolean[][] arr = new boolean[cycle*2][depths];
            int idx = 0;
            for (int i = 0; i <= cycle; i++){
                for (int j = 0 ; j < depths; j++){
                    boolean val = true;
                    if (dArr[j] + i > limit) val = false;
                    arr[idx][j] = val;
                }
                idx++;
            }
            for (int i = 1; i < cycle; i++){
                for (int j = 0 ; j < depths; j++){
                    boolean val = true;
                    if (dArr[j] + cycle - i > limit) val = false;
                    arr[idx][j] = val;
                }
                idx++;
            }
            System.out.println(eval(arr) ? "Yes" : "No");
            tests--;
        }
        in.close();
        // Scanner in = new Scanner(System.in);
        // int tests = in.nextInt();
        // while (tests > 0){
        //     int depths = in.nextInt();
        //     int[] dArr = new int[depths + 1];
        //     int cycle = in.nextInt();
        //     int limit = in.nextInt();
        //     int[] cArr = new int[2*cycle];
        //     int idx = 0;
        //     for (int i = 0 ; i <= cycle; i++){
        //         cArr[idx] = i;
        //         idx++;
        //     }
        //     for (int i = 1; i < cycle; i++){
        //         cArr[idx] = cycle - i;
        //         idx++;
        //     }
        //     dArr[0] = Integer.MIN_VALUE;
        //     for (int i = 0; i < depths; i++){
        //         dArr[i + 1] = in.nextInt();
        //     }
        //     System.out.println( eval(dArr, cArr, limit, 0, 0, 0) ? "Yes" : "No");
        //     tests--;
        // }
        // in.close();
    }
    private static boolean eval(boolean[][] arr){
        // column order traversal
        int falses = 0;
        for (int i = 0 ; i < arr.length; i++){
            if (!arr[i][0]) falses++;
        }
        if (falses == arr.length) return false;

        for (int i = 1; i < arr[0].length; i++){
            for (int k = 0 ; k < 2; k++){
                int numFalse = 0;
                for (int j = 0 ; j < arr.length; j++){
                    int up = j - 1 < 0 ? arr.length - 1: j - 1;
                    int left = i - 1;
                    if (!arr[up][left] && !arr[up][i]){
                        arr[j][i] = false;
                    }
                    if (!arr[j][i]) numFalse++;
                }
                if (numFalse == arr.length) return false;
            }
        }
        for (int i = 0; i < arr.length; i++){
            if (arr[i][arr[0].length - 1]) return true;
        }
        return false;
    }
    // private static boolean eval(int[] dArr, int[] cArr, int limit, int pos, int time, int stayed){
    //     if (pos == dArr.length) return true;
    //     int curPosDepth = dArr[pos] + cArr[time % cArr.length];
    //     if (curPosDepth > limit) return false;
    //     boolean swim = eval(dArr, cArr, limit, pos + 1, time + 1, 0);
    //     if (swim) return true;
    //     if (stayed <= cArr.length){
    //         boolean stay = eval (dArr, cArr, limit, pos, time + 1, stayed + 1);
    //         if (stay) return true;
    //     }
    //     return false;
    // }
}