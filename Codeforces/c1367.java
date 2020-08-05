import java.util.*;
public class c1367{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            in.nextInt();
            int dist = in.nextInt();
            in.nextLine();
            char[] bin = in.next().toCharArray();
            System.out.println(eval(bin, dist));
        }
        in.close();
    }
    private static int eval(char[] bin, int dist){
        // int possible = 0;
        // int first1 = -1;
        // boolean found1 = false;
        // boolean found2 = false;
        // for (int i = 0; i < bin.length(); i++){
        //     if (!found1 && bin.charAt(i) == '1') {
        //         first1 = i;
        //         found1 = true;
        //         possible += allZ(first1 - dist, dist);
        //     } else if (found1 && bin.charAt(i) == '1'){
        //         possible += allZ(i - first1 -1 - 2*dist, dist);
        //         found2 = true;
        //         first1 = i;
        //     }
        // }
        // if (!found1){
        //     return allZ(bin.length(), dist);
        // } else if (found1 && !found2){
        //     return allZ(bin.length() - (first1+1) - dist, dist) + possible;
        // }
        // return possible;
            
        int first1 = -1;
        int possible = 0;
       for (int i = 0; i < bin.length; i++){
            if (bin[i] == '1' && first1 == -1){
                first1 = i;
                possible += allZ(i - dist, dist);
            } else if (bin[i] == '1'){
                possible += allZ(i - first1 -1 - 2*dist, dist);
                first1 = i;
            }
            if (i == bin.length - 1){
                possible += allZ(bin.length - 1 - first1 - dist, dist);
            }
       }
       if (first1 == -1) return allZ(bin.length, dist);
       return possible;
    }
    private static int allZ (int length, int dist){
        if (length <= 0) return 0;
        return (int) Math.ceil((1.0*length)/(dist + 1));
    }
}