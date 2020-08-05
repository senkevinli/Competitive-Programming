import java.util.*;
public class d{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0){
            int n = in.nextInt();
            in.nextLine();
            String s = in.next();
            int sub = 1;
            Deque<Integer> ones = new ArrayDeque<>();
            Deque<Integer> zeroes = new ArrayDeque<>();
            int[] ans = new int[s.length()];
            int idx = 0;
            for (int i = 0 ; i < s.length(); i++){
                
                char cur = s.charAt(i);
                if (cur == '1'){
                    if (zeroes.size() == 0){
                        ans[idx] = sub;
                        sub++;
                        ones.push(sub-1);
                    } else {
                        int a = zeroes.pop();
                        ans[idx] = a;
                        ones.push(a);
                    }
                } else {
                    if (ones.size() == 0){
                        ans[idx] = sub;
                        sub++;
                        zeroes.push(sub - 1);
                    } else {
                        int a = ones.pop();
                        ans[idx] = a;
                        zeroes.push(a);
                    }
                }
                idx++;
            }
            int max = 0;
            for (int i = 0 ; i < ans.length; i++){
                max = Math.max(ans[i], max);
            }
            System.out.println(max);
            for (int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        in.close();
    }
}