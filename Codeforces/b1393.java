// Looked at editorial
import java.util.*;
public class b1393{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] arr = new int[num];
        for (int i = 0 ; i < num; i++){
            arr[i] = in.nextInt();
        }
        int events = in.nextInt();
        int[] changes = new int[events];
        for (int i = 0 ; i < events; i++){
            in.nextLine();
            String change = in.next();
            int amount = in.nextInt();
            if (change.charAt(0) == '+'){
                changes[i] = amount;
            } else {
                changes[i] = amount*-1;
            }
        }
        eval(arr, changes);
    }
    private static void eval(int[] arr, int[] changes){
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0 ; i < arr.length; i++){
            if (freq.containsKey(arr[i])){
                freq.put(arr[i], freq.get(arr[i]) + 1);
            } else {
                freq.put(arr[i], 1);
            }
        }
        int twos = 0;
        int fours = 0;
        for (int i : freq.keySet()){
            int val = freq.get(i);
            twos += val/2;
            fours += val/4;
        }
        for (int i = 0 ; i < changes.length; i++){
            int abs = Math.abs(changes[i]);
            int curVal = freq.getOrDefault(abs, 0);
            int toChange;
            if (changes[i] < 0){
                toChange = curVal - 1;
                if (toChange % 4 == 3) fours--;
                if (toChange % 2 == 1) twos--;
            } else {
                toChange = curVal + 1;
                if (toChange % 4 == 0) fours++;
                if (toChange % 2 == 0) twos++;
            }
            freq.put(abs, toChange);
            if (fours >= 1 && twos >= 4) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}