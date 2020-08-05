import java.util.*;
public class f1360{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            
            int num = in.nextInt();
            int length = in.nextInt();
            in.nextLine();
            char[][] arr = new char[num][length];
            for (int j = 0; j < num; j++){
                arr[j] = in.next().toCharArray();
            }
            boolean[] deleted = new boolean[num];
            String ans = eval(arr, 0, deleted, "");
            if (ans == null) System.out.println(-1);
            else System.out.println(ans);
        }
        in.close();
    }
    private static String eval(char[][] arr, int idx, boolean[] deleted, String soFar){
        if (idx == arr[0].length) return soFar;
        Set<Character> s = new HashSet<>();
        for (int j = 0 ; j < arr.length; j++){
            if (!s.contains(arr[j][idx])) s.add(arr[j][idx]);
        }
        if (s.size() != 1){
            for (char c: s){
                //System.out.println(c + " " + idx);
                //System.out.println(Arrays.toString(deleted) + " " + idx);
                boolean flag = false;
                Set<Integer> d = new HashSet<>();
                for (int j = 0; j < arr.length; j++){
                    if (c != arr[j][idx] && !deleted[j]){
                        d.add(j);
                    } else if (c != arr[j][idx] && deleted[j]){
                      flag = true;
                      break;
                    } 
                }
                if (flag) continue;
                for (int i : d){
                    deleted[i] = true;
                }
                
                String result = eval(arr, idx + 1, deleted, soFar + c);
                if (result != null) return result;
                for (int i : d){
                    deleted[i] = false;
                }
            }
            return null;
        } else {
            for (char c: s){
                return eval(arr, idx + 1, deleted, soFar + c);
            }
            return null;
        }
    }
}