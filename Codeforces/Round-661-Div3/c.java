// after competition, based off of other people's answers
import java.util.*;
public class c {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0){
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            eval(arr);
        }
        in.close();
    }
    private static void eval(int[] arr){
        int max = 0;
        for (int i = 2; i <= 100; i++){
            int least = 0;
            int greatest = arr.length - 1;
            int pairs = 0;
            while (least < greatest){
                if (arr[least] + arr[greatest] == i){
                    // found pair, cant use least OR greatest
                    least++;
                    greatest--;
                    pairs++;
                } else if (arr[least] + arr[greatest] > i){
                    // greatest cannot be used anymore
                    greatest--;
                } else {
                    // least cannot be used anymore
                    least++;
                }
            }
            max = Math.max(max, pairs);
        }
        System.out.println(max);
    }
}