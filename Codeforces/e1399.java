// Round 661, E1 Weights Divisin (easy version), Div. 3
// THIS WAS SO HARDDD
import java.util.*;
public class e1399{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        while (tests-- > 0){
            int vertices = in.nextInt();
            long maxWeight = in.nextLong();
            List<List<Edge>> adj = new ArrayList<>();
            for (int i = 0 ; i < vertices; i++){
                adj.add(new ArrayList<>());
            }
            for (int i = 0 ; i < vertices - 1; i++){
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                long weight = in.nextLong();
                adj.get(v1 - 1).add(new Edge(v2 - 1, weight, v1 - 1));
                adj.get(v2 - 1).add(new Edge(v1 - 1, weight, v2 - 1));
            }
            dfs(adj,0, null);
            PriorityQueue<Edge> cost = new PriorityQueue<>();
            long total = 0;
            for (List<Edge> le : adj){
                for (Edge e : le){
                    if (e.times != 0){
                        cost.add(e);
                        total += e.weight*e.times;
                    }
                }
            }
            int moves = 0;

            while (total > maxWeight){
                moves++;
                Edge fat = cost.poll();
                long halved = fat.weight/2;
                total -= fat.weight*fat.times - (halved*fat.times);
                fat.weight = halved;
                if (halved != 0) cost.add(fat);
            }
            System.out.println(moves);
           

        }
        in.close();
    }
    private static void dfs(List<List<Edge>> adj, int node, Edge parent){
        if (parent != null && adj.get(node).size() == 1){
            parent.times++;
            return;
        }
        for (Edge e :  adj.get(node)){
            if (parent != null && e.to == parent.from) continue;
            dfs(adj, e.to, e);
            if (parent != null) parent.times += e.times;
        }
    }
    private static class Edge implements Comparable<Edge>{
        private int from;
        private int to;
        private long weight;
        private int times;
        public Edge(int to, long weight, int from){
            this.to = to;
            this.weight = weight;
            this.from = from;
            this.times = 0;
        }
        public String toString(){
            return this.to + " " + this.weight + " " + this.times;
        }
        public int compareTo(Edge other){
            long a = other.weight*other.times - (other.weight/2)*other.times;
            long b = this.weight*this.times - (this.weight/2)*this.times;
            return Long.compare(a,b);
        }
    }
}