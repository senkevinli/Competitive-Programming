import java.util.*;
public class a1365 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int rows = in.nextInt();
            int cols = in.nextInt();
            Set<Integer> sRow = new HashSet<Integer>();
            Set<Integer> sCol = new HashSet<>();
            for (int j = 0; j < rows; j++){
                for (int k = 0; k < cols; k++){
                    int val = in.nextInt();
                    if (val == 1){
                        if(!sRow.contains(j)) sRow.add(j);
                        if (!sCol.contains(k)) sCol.add(k);
                    }
                }
            }
            int min = Math.min(rows - sRow.size(), cols - sCol.size());
            System.out.println(min % 2 == 0 ? "Vivek" : "Ashish");
            
        }
        in.close();
    }
}