// based on hints from editorial
// awful memory usage
import java.util.*;
public class e1385{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int n = in.nextInt();
            int edges = in.nextInt();
            List<List<Integer>> adj = new ArrayList<>(); //adjaceny list
            for (int j = 0; j < n; j++){
                adj.add(new ArrayList<Integer>());
            }
            int[][] given = new int[edges][3];
            for (int j = 0; j < edges; j++){
                int type = in.nextInt();
                int from = in.nextInt();
                int to = in.nextInt();
                given[j][0] = type;
                given[j][1] = from - 1;
                given[j][2] = to - 1;
                if (type != 0){
                    adj.get(from - 1).add(to - 1);
                }
            }
            // for (int j = 0; j < n; j++){
            //     System.out.println(j + " " + adj.get(j));
            // }
            List<Integer> result = topSort(adj);
            if (result == null) System.out.println("NO");
            else {
                Map<Integer, Integer> m = new HashMap<>();
                int idx = 0;
                for (int j : result){
                    m.put(j, idx++);
                }
                System.out.println("YES");
                for (int j = 0; j < edges; j++){
                    if (given[j][0] == 1) System.out.println((given[j][1] + 1) + " " + (given[j][2] + 1));
                    else {
                        int first = given[j][1];
                        int second = given[j][2];
                        int i1 = m.get(first);
                        int i2 = m.get(second);
                        first = first + 1;
                        second = second + 1;
        
                        System.out.println(i1 < i2 ? (first +  " " + second) : (second + " " + first));
                    }
                }
            }
        }
        in.close();
    }
    private static List<Integer> topSort(List<List<Integer>> adj){
        List<Integer> ret = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < adj.size(); i++){
            if (visited.contains(i)) continue;
            if (!helper(i, adj, visited, ret, new HashSet<Integer>())) return null;
        }

        return ret;
    }
    private static boolean helper (int node, List<List<Integer>> adj, Set<Integer> visited, List<Integer> stack, Set<Integer> it){
        it.add(node);
        for (int i : adj.get(node)){
            if (visited.contains(i)) continue;
            if (it.contains(i)) return false;
            if (!helper(i, adj, visited, stack, it)) return false;

        }
        stack.add(0, node);
        visited.add(node);
        return true;
    }
}