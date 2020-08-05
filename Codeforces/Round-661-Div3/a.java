import java.util.*;
public class a {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                int num = in.nextInt();
                arr[i] = num;
            }
            System.out.println(eval(arr) ? "YES": "NO");
        }
        
        in.close();
    }
    private static boolean eval(int[] arr){
        if (arr.length == 1) return true;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i+1] - arr[i] > 1) return false;
        }
        return true;
    }
}