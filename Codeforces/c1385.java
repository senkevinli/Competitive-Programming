import java.util.*;
public class c1385{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int size = in.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++){
                arr[j] = in.nextInt();
            }
            System.out.println(eval(arr));
        }
        in.close();
    }
    private static int eval(int[] arr){
        if (arr.length == 1) return 0;
        int prev = arr[arr.length - 1];
        boolean last = true;
        int length = 1;
        for (int i = arr.length - 2; i >= 0; i--){
            int curr = arr[i];
            if (curr > prev && !last){
                return arr.length - length;
            } 
            if (curr >= prev && last){
                length++;
                last = true;
            } else if (curr <= prev){
                length++;
                last = false;
            }
            prev = curr;
        }
        return arr.length - length;
    }
}