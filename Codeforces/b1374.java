import java.util.*;
public class b1374 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int n = in.nextInt();
            System.out.println(eval(n));
        }
        in.close();
    }
    private static int eval(int n){
        int twos = 0;
        int threes = 0;
        while (n != 1){
            if (n % 3 == 0){
                n = n/3;
                threes++;
            } 
            else if(n % 2 == 0){
                n = n/2;
                twos++;
            } else return -1;
        }
        if (twos > threes) return -1;
        return threes + threes - twos;
    }
}