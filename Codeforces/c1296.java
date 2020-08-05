import java.util.*;
public class c1296 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int tests = in.nextInt();
        in.nextLine();
        while (tests > 0){
            in.next();
            String path = in.next();
            int[] result = eval(path);
            if (result != null){
                System.out.print(result[0] + " " + result[1]);
            } else {
                System.out.print(-1);
            }
            tests--;
            System.out.println();
        }
        in.close();
    }
    private static int[] eval(String path){
        String prev = "0 0";
        int prevX = 0;
        int prevY = 0;
        Map<String,Integer> traversed = new HashMap<>();
        int shortStart = 0;
        int shortEnd = Integer.MAX_VALUE;
        traversed.put(prev, 1);
        for (int i = 0 ; i < path.length(); i++){
            char step = path.charAt(i);
            int nextX = prevX;
            int nextY = prevY;
            if (step == 'L'){
                nextX = prevX - 1;
            } else if (step == 'R'){
                nextX = prevX + 1;
            } else if (step == 'U'){
                nextY = prevY - 1;
            } else {
                nextY = prevY + 1;
            }
            String next = nextX + " " + nextY;

            if (traversed.containsKey(next)){
                int dist = i + 1 - traversed.get(next);
                if (dist < (shortEnd - shortStart)){
                    shortStart = traversed.get(next);
                    shortEnd = i + 1;
                }
            }
            traversed.put(next, i+2);
            prev = next;
            prevX = nextX;
            prevY = nextY;
        }
        if (shortEnd == Integer.MAX_VALUE){
            return null;
        } else {
            return new int[] { shortStart, shortEnd };
        }
    }
}