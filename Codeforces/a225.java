import java.util.*;
public class a225 {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        int[] cows = new int[tests];
        int idx = 0;
        while (tests > 0){
            cows[idx] = in.nextInt();
            tests--;
            idx++;
        }
        in.close();
        long rightFacing = 0;
        long pairs = 0;
        for (int i = 0; i < cows.length; i++){
            if(cows[i] == 1) rightFacing++;
            else pairs += rightFacing;
        }
        System.out.println(pairs);
    }
}