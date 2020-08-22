// Fox and Names, Round 290, Div 2
// Difficulty: 1600
import java.util.*;
public class c510{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int authors = in.nextInt();
        in.nextLine();
        String[] a = new String[authors];
        for (int i = 0 ; i < authors; i++){
            a[i] = in.next();
        }
        eval(a);
        in.close();
    }
    private static void eval(String[] a){
        List<Set<Integer>> alph = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++){
            alph.add(new HashSet<>());
        }
        boolean b = false;
        for (int i = 0 ; i < a.length - 1; i++){
            int idx = 0;
            String f = a[i];
            String s = a[i+1];
            while(idx < f.length() && idx < s.length() && s.charAt(idx) == f.charAt(idx)){
                idx++;
            }
            
            if (idx == s.length()){
                b = true;
                break;
            }
            if (idx != f.length() && idx != s.length()){
                alph.get(f.charAt(idx) - 'a').add((s.charAt(idx) - 'a'));
            }
        }
        if (!b){
            System.out.println(topSort(alph));
        } else {
            System.out.println("Impossible");
        }
        
    }
    private static String topSort(List<Set<Integer>> alph){
        Set<Integer> visited = new HashSet<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0 ; i < alph.size(); i++){
            boolean result = dfs(i, alph, visited, s, new HashSet<>());
            if (!result) return "Impossible";
        }
        return s.toString();
    }
    private static boolean dfs (int node, List<Set<Integer>> alph, Set<Integer> visited, StringBuilder s, Set<Integer> curr){
        if (!visited.contains(node)){
            curr.add(node);
            for (int i : alph.get(node)){
                if (!visited.contains(i) && curr.contains(i)) return false;
                if (!dfs(i, alph, visited, s, curr)) return false;;
            }
            visited.add(node);
            //curr.remove(node);
            s.insert(0, (char) (node + 97));
        }
        return true;
    }
}