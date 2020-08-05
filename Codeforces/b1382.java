import java.util.*;
public class b1382{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int piles = in.nextInt();
            int[] arr = new int[piles];
            for (int j = 0; j < piles; j++){
                arr[j] = in.nextInt();
            }
            System.out.println(eval(arr) ? "First" : "Second");
        }
        in.close();
    }
    private static boolean eval(int[] arr){
        if (arr.length == 1) return true;
        boolean ret = true;
        for (int i = arr.length - 2; i >= 0; i--){
            if (ret && arr[i] == 1) ret = false;
            else ret = true;
        }
        return ret;
    }
}