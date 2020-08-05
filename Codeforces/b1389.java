import java.util.*;
public class b1389 {
    static int[][] dp;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        for (int i = 0 ; i < tests; i++){
            int size = in.nextInt();
            int tMax = in.nextInt();
            int lMax = in.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++){
                arr[j] = in.nextInt();
            }
            dp = new int[size][lMax + 1];
            //System.out.println(eval(tMax, lMax, arr, 0, false));
            System.out.println(eval2(tMax, lMax, arr));
            // for (int[] a : dp){
            //     System.out.println(Arrays.toString(a));
            // }
        }
        in.close();
    }
    // recursive dp, bad solution
    private static int eval(int total, int left, int[] arr, int index, boolean went){
        if (total < 0) return 0;
        if (index > arr.length - 1 || index < 0) return 0;
        if (dp[index][left] != 0) return dp[index][left];
        int acc = arr[index];

        int l = 0;
        int r = 0;
        if (!went && left > 0){
            l = eval(total - 1, left - 1, arr, index - 1, true);
        }
        r = eval (total - 1, left, arr, index + 1, false);
        int sum = acc + Math.max(l, r);
        dp[index][left] = sum;
        return sum;
    }
    // better way (from editorial)
    private static int eval2(int total, int left, int[] arr){
        int realLeft = Math.min(left, total/2);
        int ret = -1;
        for (int i = 0; i <= realLeft; i++){
            int bound = total - 2*i;
            int maxPair = -1;
            int acc = 0;
            for (int j = 0; j <= bound; j++){
                acc += arr[j];
                if (j + 1 < arr.length && maxPair < arr[j] + arr[j+1]){
                    maxPair = arr[j] + arr[j+1];
                }
            }
            ret = Math.max(ret, acc + i*maxPair);
        }
        return ret;
    }
}
/*
Good solution by TimmyThinMints
import java.util.*;
import java.io.*;
 
public class B {
    static int[][][] dp;// [z][isBack][i]
    static int[] a;
 
    public static void main(String[] args) throws Exception {
        FastScanner in = new FastScanner();
        int T = in.nextInt();
        for (int R = 0; R < T; R++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int z = in.nextInt();
            a = new int[n];
            dp = new int[z + 1][2][n + 1];
 
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            System.out.println(rec(0, 0, z, k));
        }
    }
 
    static int rec(int i, int isBack, int z, int k) {
        if (dp[z][isBack][i] != 0) {
            return dp[z][isBack][i];
        }
        if (i == a.length - 1 || k == 0) {
            return a[i];
        }
        if (isBack == 1 || z == 0 || i == 0) {
            return dp[z][isBack][i] = rec(i + 1, 0, z, k - 1) + a[i];
        }
        return dp[z][isBack][i] = Math.max(rec(i - 1, 1, z - 1, k - 1), rec(i + 1, 0, z, k - 1)) + a[i];
    }
 
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
}
*/