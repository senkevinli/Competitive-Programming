import java.util.*;
public class b1385 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int size = in.nextInt();
            int[] arr = new int[size*2];
            for (int j = 0; j < size*2; j++){
                arr[j] = in.nextInt();
            }
            eval(arr, size);
        }
        in.close();
    }
    private static void eval(int[] arr, int size){
        Set<Integer> s = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++){
            s.add(arr[i]);
        }
        for (int a : s){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}